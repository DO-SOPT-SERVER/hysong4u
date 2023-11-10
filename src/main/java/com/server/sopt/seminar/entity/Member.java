package com.server.sopt.seminar.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nickname;
    private int age;

    @Embedded
    private Sopt sopt;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL) //CascadeType.ALL: member가 삭제되면 post도 삭제됨
        private List<Post> posts = new ArrayList<>();

    @Builder
    public Member(String name, String nickname, int age, Sopt sopt) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.sopt = sopt;
    }

    public void updateSOPT(Sopt sopt) {}
}
