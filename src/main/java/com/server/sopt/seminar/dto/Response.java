package com.server.sopt.seminar.dto;

import lombok.Getter;

@Getter
public class Response {
    private int code;
    private String status;
    private boolean success;

    public Response(int code, String status, boolean success){
        this.code = code;
        this.status = status;
        this.success = success;
    }
}
