package com.server.sopt.seminar.repository;

import com.server.sopt.seminar.entity.Member;
import com.server.sopt.seminar.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  PostJpaRepository  extends JpaRepository<Post, Long>{
    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);


}
