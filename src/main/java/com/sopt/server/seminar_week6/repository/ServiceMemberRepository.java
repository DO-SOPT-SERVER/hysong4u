package com.sopt.server.seminar_week6.repository;

import com.sopt.server.seminar_week6.domain.ServiceMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceMemberRepository extends JpaRepository<ServiceMember, Long> {
    Optional<ServiceMember> findByNickname(String nickname);
}
