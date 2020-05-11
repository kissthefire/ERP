package com.erp.log;

import com.erp.util.converter.JsonConverter;
import com.erp.util.result.Response;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 版本         开发者               创建日期
 * 1.0.0   InetCommunity(^_^)on     2019/1/18.
 * 日志拦截aop
 */
@Aspect
@Configuration
public class LogAspect {
    private LogBean log=null;

    private Logger logger= LogManager.getLogger(LogAspect.class.getName());

    @Pointcut("execution(public * com.erp.controller..*.*(..))")
    public void webLog(){
    }

    /**
     * 方法调用前触发
     * 记录目标方法开始时间
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        log.setStartTimeMillis(System.currentTimeMillis());
    }

    /**
     * 方法调用玩之后触发
     * 记录目标方法结束时间
     * @param joinPoint
     */
    @After("webLog()")
    public void doAfter(JoinPoint joinPoint){
        log.setEndTimeMillis(System.currentTimeMillis());
        //System.out.println(log.toString());
        logger.info(log.toString());
        if(logger.isDebugEnabled()){
            logger.debug(log.toString());
        }
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint pjp){
        log=new LogBean();
        Response response=new Response();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes)requestAttributes;
        HttpServletRequest request= servletRequestAttributes.getRequest();
        //设置请求方法
        log.setMethod(request.getMethod());
        //获取请求参数
        log.setInputParamMap(request.getParameterMap());
        if("POST".equalsIgnoreCase(log.getMethod())){
            Object[] paramsArray=pjp.getArgs();
            log.setParamStr(argArrayToString(paramsArray));
        }else{
            log.setParamStr(log.getInputParamMap().toString());
            log.setInputParamMap((Map<?,?>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE));
            if(log.getInputParamMap()==null || log.getInputParamMap().size()==0){
                log.setParamStr(request.getQueryString());
            }else{
                log.setParamStr(log.getInputParamMap().toString());
            }
        }
        //请求地址
        log.setRequestPath(request.getRequestURI());
        log.setClientIp(getIpAddress(request));

        Object result=new Object();
        try{
            result=pjp.proceed();  //result就是被拦截方法的返回值
        }catch (DuplicateKeyException d){
            d.printStackTrace();
            String msg=d.getCause().getMessage().split("'")[0];
            response.setStatus(Response.DATAERROR).setMsg("'"+msg+"'不能重复添加！");
            result=response;
        }catch (Throwable e){
            e.printStackTrace();
            response.setStatus(Response.ERROR).setMsg("Server Error");
            result=response;
        }
        if(result instanceof ResponseEntity){
            log.setReturned("file");
        }else if(result instanceof Response){
            log.setReturned(result);
        }else{
            log.setReturned(result);
        }
        Signature signature=pjp.getSignature();
        log.setClazz(signature.toString());
        return result;
    }

    /**
     * 传入参数数组转字符串
     * @param paramArray
     * @return
     */
    private String argArrayToString(Object[] paramArray){
        StringBuffer params=new StringBuffer("");
        if(ArrayUtils.isNotEmpty(paramArray)){
            for(Object paramObj:paramArray){
                if(paramObj!=null && paramObj.getClass().getName().startsWith("com.erp")){
                    try{
                        String jsonObj= JsonConverter.convertObjToJson(paramObj);
                        params.append(jsonObj);
                        params.append(" ");

                    }catch (Exception ex){
                        if(logger.isErrorEnabled()){
                            logger.error(ex);
                        }
                    }
                }
            }
        }
        return params.toString().trim();
    }

    /**
     * 获取ip地址
     * @param request
     * @return
     */
    public String getIpAddress(HttpServletRequest request){
        String Xip=request.getHeader("X-Real-IP");
        String XFor=request.getHeader("X-Forward-For");
        //多次反向代理，会产生多个ip值，只有第一个ip才是真实ip
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(XFor) && !"unKonwn".equalsIgnoreCase(XFor)){
            int index=XFor.indexOf(",");
            if(index!=-1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor=Xip;
        if(org.apache.commons.lang3.StringUtils.isNotEmpty(XFor)&& !"unKonwn".equalsIgnoreCase(XFor)){
            return XFor;
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }
}
