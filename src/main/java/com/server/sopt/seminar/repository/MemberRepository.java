package com.server.sopt.seminar.repository;

import com.server.sopt.seminar.entity.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
    default Member findByIdOrThrow(Long id){
        return findById(id).orElseThrow(()
                -> new EntityNotFoundException("해당하는 id의 회원이 없습니다."));
    }
}
