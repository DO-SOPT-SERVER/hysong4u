package com.sopt.server.seminar_week6.domain;

import com.sopt.server.seminar_week6.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "post")  //post Table이랑 매핑
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT") // varchar대신 Text. 길이 제한 없는 텍스트 타입
    private String content;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id") // 일대다 관계에서 다 부분이 외래키를 갖음(연관관계의 주인)
    private Member member;

    @Column(name = "category_id")
    private CategoryId categoryId;
    @Builder
    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    @Builder(builderMethodName = "builderWithImageUrl")
    public Post(String title, String content, String imageUrl,Member member) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.member = member;
    }

    public void updateContent(String content) {
        this.content = content;
    }
    public void addCategory(CategoryId categoryId) {
        this.categoryId = categoryId;
    }
}

