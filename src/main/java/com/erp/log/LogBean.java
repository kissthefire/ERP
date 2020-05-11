package com.erp.log;

import com.erp.util.converter.JsonConverter;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.UUID;

/**
 * 版本         开发者               创建日期
 * 1.0.0   InetCommunity(^_^)on     2019/1/18.
 */
public class LogBean {
    private String requestId=UUID.randomUUID().toString();
    private String requestPath=null;
    private String method=null;
    private String paramStr="";
    private Map<?,?> inputParamMap=null;  //传入参数
    private Map<String,Object> outputParamMap=null;
    private Object returned;
    private String clazz;
    private String clientIp;
    private long startTimeMillis=0; //开始时间
    private long endTimeMillis=0;  //结束时间

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamStr() {
        return paramStr;
    }

    public void setParamStr(String paramStr) {
        this.paramStr = paramStr;
    }

    public Map<?, ?> getInputParamMap() {
        return inputParamMap;
    }

    public void setInputParamMap(Map<?, ?> inputParamMap) {
        this.inputParamMap = inputParamMap;
    }

    public Map<String, Object> getOutputParamMap() {
        return outputParamMap;
    }

    public void setOutputParamMap(Map<String, Object> outputParamMap) {
        this.outputParamMap = outputParamMap;
    }

    public Object getReturned() {
        return returned;
    }

    public void setReturned(Object returned) {
        this.returned = returned;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public long getStartTimeMillis() {
        return startTimeMillis;
    }

    public void setStartTimeMillis(long startTimeMillis) {
        this.startTimeMillis = startTimeMillis;
    }

    public long getEndTimeMillis() {
        return endTimeMillis;
    }

    public void setEndTimeMillis(long endTimeMillis) {
        this.endTimeMillis = endTimeMillis;
    }

    @Override
    public String toString() {
        long ms=endTimeMillis-startTimeMillis;
        String tps=ms+"ms";

        String optTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);

        String resultStr= JsonConverter.convertObjToJson(returned);

        StringBuffer stb = new StringBuffer("\n");
        stb.append("===================接口日志===========================");
        stb.append("\r\n");

        stb.append("请求ID: ");
        stb.append(requestId);
        stb.append("\r\n");

        stb.append("请求地址： ");
        stb.append(requestPath);
        stb.append("\r\n");

        stb.append("请求时间： ");
        stb.append(optTime);
        stb.append("\r\n");

        stb.append("处理用时: ");
        stb.append(tps);
        stb.append("\r\n");

        stb.append("客户端IP: ");
        stb.append(clientIp);
        stb.append("\r\n");

        stb.append("参数： ");
        stb.append(paramStr);
        stb.append("\r\n");

        stb.append("返回结果： ");
        stb.append(resultStr);
        stb.append("\r\n");

        stb.append("===================接口日志===========================");
        stb.append("\r\n");
        stb.append("\r\n");

        return stb.toString();
    }
}
