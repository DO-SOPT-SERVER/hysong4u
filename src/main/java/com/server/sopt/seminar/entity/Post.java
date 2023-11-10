package com.server.sopt.seminar.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "post")  //post Table이랑 매핑

public class Post extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    @Column(columnDefinition = "TEXT") // varchar대신 Text. 길이 제한 없는 텍스트 타입
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id") // 일대다 관계에서 다 부분이 외래키를 갖음(연관관계의 주인)
    private Member member;

    @Builder
    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public Long getId() {
        return postId;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}
