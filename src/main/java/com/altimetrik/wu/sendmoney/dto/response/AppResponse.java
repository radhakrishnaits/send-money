package com.altimetrik.wu.sendmoney.dto.response;

import org.springframework.http.HttpStatus;

public class AppResponse<T> {

    private T res;
    private String message;
    private HttpStatus status;
    public AppResponse(){}
    public AppResponse(T res, String message, HttpStatus status) {
        this.res = res;
        this.message = message;
        this.status = status;
    }

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }


}
