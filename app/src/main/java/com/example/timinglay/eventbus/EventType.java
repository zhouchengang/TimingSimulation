package com.example.timinglay.eventbus;



public class EventType {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public EventType(String msg){
        this.msg = msg;
    }
}