package com.server.sopt.seminar.dto.request;

import com.server.sopt.seminar.entity.Sopt;
import lombok.Data;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private Sopt sopt;
}
