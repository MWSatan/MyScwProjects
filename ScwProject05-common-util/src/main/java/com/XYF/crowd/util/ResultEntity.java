package com.XYF.crowd.util;

/**
 * @username 熊一飞
 */

/**
 * 统一整个项目中Ajax请求返回的结果（未来也也可以用于分布式架构各个模块）
 * @param <T>
 */
public class ResultEntity<T> {


    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";


    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    //    用来封装请求处理的结果是成功还是失败
    private String result;

//    用于返回失败时返回的信息
    private String message;

//    要返回的数据
    private T data;


    /**
     * 请求处理成功且不需要返回数据使用的工具方法
     * @return
     */
//    使用泛型方法
    public static <Type> ResultEntity<Type> successWithoutData(){
        return new ResultEntity<Type>(SUCCESS,null,null);
    }

    /**
     * 请求处理成功且需要返回数据时使用的工具方法
     * @param data
     * @return
     */
    public static <Type> ResultEntity<Type> successWithData(Type data){
        return new ResultEntity<Type>(SUCCESS,null,data);
    }

    /**
     * 请求处理失败且需要返回数据时使用的工具方法
     * @param message 失败的错误信息
     * @return
     */
    public static <Type> ResultEntity<Type> failWithMessage(String message){
        return new ResultEntity<Type>(FAIL,message,null);
    }


    public ResultEntity() {
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
