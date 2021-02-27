package com.springboot.project.userdataapp.API;

import java.util.List;

import com.springboot.project.userdataapp.Entities.LoginHistory;

public class APIResponse {
    private int status;
    private String message;
    private Object result;
    private List<LoginHistory> l;

    

    public int getStatus() {
        return status;
    }

    public APIResponse(int status, String message, Object result, List<LoginHistory> l) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.l=l;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public List<LoginHistory> getL() {
        return l;
    }

    public void setL(List<LoginHistory> l) {
        this.l = l;
    }

    
}
