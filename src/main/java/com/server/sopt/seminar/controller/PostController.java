package com.server.sopt.seminar.controller;

import com.server.sopt.seminar.dto.request.PostCreateRequest;
import com.server.sopt.seminar.dto.response.PostGetResponse;
import com.server.sopt.seminar.dto.request.PostUpdateRequest;
import com.server.sopt.seminar.service.PostService;
import jakarta.persistence.PostUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private static final String CUSTOM_AUTH_ID = "X-Auth-id";
    private final PostService postService;

    //post 조회
    @GetMapping("/{postId}")
    public ResponseEntity<PostGetResponse> getPostById(@PathVariable Long postId){
        return ResponseEntity.ok(postService.getById(postId));
    }

    //멤버의 post 전부 조회
    @GetMapping
    public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId){
        return ResponseEntity.ok(postService.getPosts(memberId));
    }

    //post 생성
    @PostMapping
    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
                                           @RequestBody PostCreateRequest request){
        URI location = URI.create("api/post/" + postService.create(request, memberId));


        return ResponseEntity.created(location).build();
    }

    //post 수정
    @PatchMapping("/{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        postService.update(postId, request);
        return ResponseEntity.noContent().build();
    }
    //post 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
        return ResponseEntity.noContent().build();
    }
}
