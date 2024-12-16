package com.example.cookie.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @GetMapping("/set-cookie")
    public ResponseEntity<String> setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("username", "홍길동");
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7일 유지
        cookie.setPath("/"); // 모든 경로에서 유효
        cookie.setHttpOnly(true); // JavaScript 접근 불가
        cookie.setSecure(true); // HTTPS에서만 전송
        response.addCookie(cookie);
        return ResponseEntity.ok("Cookie set!");
    }

    @GetMapping("/get-cookie")
    public ResponseEntity<String> getCookie(@CookieValue(value = "username", defaultValue = "Guest") String username) {
        return ResponseEntity.ok("Hello, " + username);
    }

    @GetMapping("/get-all-cookies")
    public ResponseEntity<String> getAllCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " = " + cookie.getValue());
            }
        }
        return ResponseEntity.ok("Cookies printed in server logs.");
    }

    @GetMapping("/delete-cookie")
    public ResponseEntity<String> deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("sessionId", null); // 값은 null로 설정
        cookie.setMaxAge(0); // 즉시 만료
        cookie.setPath("/"); // 경로 일치
        response.addCookie(cookie);
        return ResponseEntity.ok("Cookie deleted");
    }

    @GetMapping("/delete-specific-cookie")
    public ResponseEntity<String> deleteSpecificCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    Cookie deleteCookie = new Cookie("username", null);
                    deleteCookie.setMaxAge(0); // 즉시 만료
                    deleteCookie.setPath("/");
                    response.addCookie(deleteCookie);
                }
            }
        }
        return ResponseEntity.ok("Specific cookie deleted");
    }
}
