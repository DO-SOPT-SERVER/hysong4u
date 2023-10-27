package com.server.sopt.seminar.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Response {
    private int code;
    private String status;
    private boolean success;

    public static Response of(int code, String status, boolean success){
       return Response.builder()
               .code(code)
               .status(status)
               .success(success)
               .build();
    }
}
