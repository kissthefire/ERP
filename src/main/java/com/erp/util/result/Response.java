package com.erp.util.result;

/**
 * 配置统一响应格式
 */
public class Response {
    private Integer status;
    private Object data;
    private String msg;


    /**
     * 请求成功
     */
    public static final int SUCCESS=200;

    /**
     * 请求数据不正确
     */
    public static final int DATAERROR=300;

    /**
     * 无权限访问
     */
    public static final int NOACCESS=100;

    /**
     * 服务器出错
     */
    public static final int ERROR=500;

    public Integer getStatus() {
        return status;
    }

    public Response setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Response setData(Object data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Response successWithEmpty(){
        Response response=new Response();
        response.setStatus(Response.SUCCESS);
        response.setData(new Response());
        response.setMsg("ok");
        return response;
    }

    public static Response success(Object data){
        Response response=new Response();
        response.setStatus(Response.SUCCESS);
        response.setData(data);
        response.setMsg("ok");
        return response;
    }

    public static Response error(String msg){
        Response response=new Response();
        response.setStatus(Response.DATAERROR);
        response.setMsg(msg);
        return response;
    }
}
