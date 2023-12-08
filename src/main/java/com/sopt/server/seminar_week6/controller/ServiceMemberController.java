package com.sopt.server.seminar_week6.controller;

import com.sopt.server.seminar_week6.domain.ServiceMember;
import com.sopt.server.seminar_week6.dto.PostCreateRequest;
import com.sopt.server.seminar_week6.dto.ServiceMemberRequest;
import com.sopt.server.seminar_week6.service.ServiceMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class ServiceMemberController {

    private final ServiceMemberService serviceMemberService;


    @PostMapping("sign-up")
    public ResponseEntity<Void> signUp(@RequestBody ServiceMemberRequest request){
        URI location = URI.create(serviceMemberService.create(request));
        return ResponseEntity.created(location).build();
    }

    @PostMapping("sign-in")
    public ResponseEntity<Void> signIn(@RequestBody ServiceMemberRequest request){
      serviceMemberService.signIn(request);
        return ResponseEntity.noContent().build();
    }



}
