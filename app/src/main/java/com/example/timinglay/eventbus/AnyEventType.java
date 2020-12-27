package com.example.timinglay.eventbus;



public class AnyEventType {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AnyEventType(String msg){
        this.msg = msg;
    }
}