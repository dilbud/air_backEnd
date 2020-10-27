package com.dbx.air.mvc.rest.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

public class SuccessMsg<E>{
    public String status;
    public String message;
    public String timeStamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Page page;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public E data;

    public SuccessMsg() {
    }

    public SuccessMsg(String status, String message, String timeStamp, E data) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
