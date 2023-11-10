package com.server.sopt.seminar.dto.response;

import com.server.sopt.seminar.entity.Post;

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


