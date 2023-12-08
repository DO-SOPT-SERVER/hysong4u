package com.sopt.server.seminar_week6.dto;

import com.sopt.server.seminar_week6.domain.Sopt;
import lombok.Data;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private Sopt sopt;
}
