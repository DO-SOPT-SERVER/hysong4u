package com.server.sopt.seminar.service;

import com.server.sopt.seminar.dto.request.PostCreateRequest;
import com.server.sopt.seminar.dto.request.PostUpdateRequest;
import com.server.sopt.seminar.dto.response.PostGetResponse;
import com.server.sopt.seminar.entity.Member;
import com.server.sopt.seminar.entity.Post;
import com.server.sopt.seminar.repository.MemberRepository;
import com.server.sopt.seminar.repository.PostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PostUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostJpaRepository postJpaRepository;
    private final MemberRepository memberJpaRepository;

    @Transactional
    public String create(PostCreateRequest request, Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);

        Post post = postJpaRepository.save(
                Post.builder()
                        .member(member)
                        .title(request.title())
                        .content(request.content()).build());
        return post.getId().toString();
    }

    public PostGetResponse getById(Long postId) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(()->new EntityNotFoundException("해당 게시글이 없습니다."));
        return PostGetResponse.of(post);
    }

    public List<PostGetResponse> getPosts(Long memberId) {
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(PostGetResponse::of)
                .toList();
    }

    @Transactional
    public void update(Long postId, PostUpdateRequest request) {
     Post post = postJpaRepository.findById(postId)
             .orElseThrow(()->new EntityNotFoundException("해당 게시글이 없습니다."));
        post.updateContent(request.content());

    }
    @Transactional
    public void deleteById(Long postId) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(()->new EntityNotFoundException("해당 게시글이 없습니다."));
        postJpaRepository.delete(post);
    }


}
