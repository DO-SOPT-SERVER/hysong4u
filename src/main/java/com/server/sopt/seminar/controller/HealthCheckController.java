package com.server.sopt.seminar.controller;

import com.server.sopt.seminar.dto.HealthCheckResponse;
<<<<<<< HEAD
import com.server.sopt.seminar.dto.Response;
=======
>>>>>>> be858bb7a74d5f0e4b375239c6e636bf09373843
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/v1" )
    public Map<String, String> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("v3")
    public String healthCheck3(){
        return ("OK");
    }
    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthCheckV4() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
    public ResponseEntity<HealthCheckResponse> healthCheckV5() {
        return ResponseEntity.ok(new HealthCheckResponse());
    }
<<<<<<< HEAD

    @GetMapping("/v6") //1주차 심화과제
    public Response healthCheckV6() {
        return new Response(200, "OK", true);
    }

=======
>>>>>>> be858bb7a74d5f0e4b375239c6e636bf09373843
}