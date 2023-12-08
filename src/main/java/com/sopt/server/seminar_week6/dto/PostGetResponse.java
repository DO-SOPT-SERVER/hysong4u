package com.sopt.server.seminar_week6.dto;


import com.sopt.server.seminar_week6.domain.Post;

public record PostGetResponse(
    Long id,
    String title,
    String content

) {
    public static PostGetResponse of(Post post){
        return new PostGetResponse(
                post.getId(),
                post.getTitle(),
                post.getContent()

        );
    }
}


