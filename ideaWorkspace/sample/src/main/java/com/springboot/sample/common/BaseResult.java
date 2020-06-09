package com.springboot.sample.common;

import java.io.Serializable;

/**
 * @author Aaron
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 信息码，从配置文件中获取对应的文本信息
     */
    private String messageCode;

    /**
     * 信息描述
     */
    private String messageDescription;

    /**
     * 返回的结果
     */
    private Object data;

    /**
     * 是否成功
     */
    private boolean isSuccess;

    /**
     * 数据总数
     */
    private Integer total;

    /**
     * 跳转url
     */
    private String jumpUrl;

    public BaseResult() {
    }

    public BaseResult(Object data) {
        this.data = data;
    }

    public BaseResult(Object data, boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
    }

    public BaseResult(Object data, boolean isSuccess, Integer total) {
        this.data = data;
        this.isSuccess = isSuccess;
        this.total = total;
    }

    public BaseResult(String messageCode, Object data) {
        this.messageCode = messageCode;
        this.data = data;
    }

    public BaseResult(String messageCode, Object data, Integer total) {
        this.messageCode = messageCode;
        this.data = data;
        this.total = total;
    }

    public BaseResult(String messageCode, Object data, boolean isSuccess) {
        this.messageCode = messageCode;
        this.data = data;
        this.isSuccess = isSuccess;
    }

    public BaseResult(String messageCode, String messageDescription, Object data) {
        this.messageCode = messageCode;
        this.messageDescription = messageDescription;
        this.data = data;
    }

    public BaseResult(String messageCode, String messageDescription, Object data, Integer total) {
        this.messageCode = messageCode;
        this.messageDescription = messageDescription;
        this.data = data;
        this.total = total;
    }

    public BaseResult(String messageCode, Object data, boolean isSuccess, String jumpUrl) {
        this.messageCode = messageCode;
        this.data = data;
        this.isSuccess = isSuccess;
        this.jumpUrl = jumpUrl;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
