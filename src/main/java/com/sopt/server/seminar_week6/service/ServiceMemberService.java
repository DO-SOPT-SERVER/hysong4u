package com.sopt.server.seminar_week6.service;

import com.sopt.server.seminar_week6.domain.ServiceMember;
import com.sopt.server.seminar_week6.dto.ServiceMemberRequest;
import com.sopt.server.seminar_week6.repository.ServiceMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceMemberService {
    private final ServiceMemberRepository servieMemberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String create(ServiceMemberRequest request){
        ServiceMember serviceMember = ServiceMember.builder()
                .nickname(request.nickname())
                .password(passwordEncoder.encode(request.password()))
                .build();
        servieMemberRepository.save(serviceMember);
        return serviceMember.getId().toString();
    }

    public void signIn(ServiceMemberRequest request){
        ServiceMember serviceMember = servieMemberRepository.findByNickname(request.nickname())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));
        if(!passwordEncoder.matches(request.password(), serviceMember.getPassword())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
    }
}
