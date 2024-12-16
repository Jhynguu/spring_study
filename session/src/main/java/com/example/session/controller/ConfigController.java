package com.example.session.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    // 세션에 데이터 저장
    @GetMapping("/set-session")
    public ResponseEntity<String> setSession(HttpSession session) {
        session.setAttribute("user", "홍길동");
        session.setAttribute("role", "admin");
        return ResponseEntity.ok("Session data set!");
    }

    // 세션 데이터 읽기
    @GetMapping("/get-session")
    public ResponseEntity<String> getSession(HttpSession session) {
        String user = (String) session.getAttribute("user");
        String role = (String) session.getAttribute("role");

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No active session found.");
        }

        return ResponseEntity.ok("User: " + user + ", Role: " + role);
    }

    // 세션 무효화(로그아웃)
    @PostMapping("/invalidate-session")
    public ResponseEntity<String> invalidateSession(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return ResponseEntity.ok("Session invalidated!");
    }

    // 세션 ID 재발급 - 로그인 성공 시 기존 세션 ID를 무효화하고 새 세션 ID를 발급
    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request) {
        HttpSession oldSession = request.getSession(false);
        if (oldSession != null) {
            oldSession.invalidate(); // 기존 세션 무효화
        }
        HttpSession newSession = request.getSession(true); // 새 세션 생성
        newSession.setAttribute("user", "홍길동");

        return ResponseEntity.ok("Login successful!");
    }


}
