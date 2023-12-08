package com.sopt.server.seminar_week6.repository;

import com.sopt.server.seminar_week6.domain.Post;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    default Post findByIdOrThrow(Long id){
        return findById(id).orElseThrow(()
                -> new EntityNotFoundException("해당하는 id의 게시글이 없습니다."));
    }
    List<Post> findAllByMemberId(Long memberId);

}
