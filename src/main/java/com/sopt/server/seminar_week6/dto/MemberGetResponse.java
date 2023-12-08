package com.sopt.server.seminar_week6.dto;


import com.sopt.server.seminar_week6.domain.Member;
import com.sopt.server.seminar_week6.domain.Sopt;

public record MemberGetResponse(
    String name,
    String nickname,
    int age,
    Sopt soptInfo
) {
    public static MemberGetResponse of(Member member){
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
