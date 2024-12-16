package com.example.swagger.controller;

import com.example.swagger.domain.User;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Management", description = "사용자 관리 관련 API")
@RestController
public class UserController {

    @Operation(
            summary = "사용자 목록 조회",
            description = "모든 사용자의 목록을 반환합니다.",
            tags = {"User Management"}
    )
    @ApiResponse(responseCode = "200", description = "성공적으로 사용자 목록을 반환")
    @GetMapping("/users")
    public List<String> getUsers() {
        return List.of("홍길동", "이몽룡");
    }

//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "성공적으로 반환"),
//            @ApiResponse(responseCode = "404", description = "사용자를 찾을 수 없음")
//    })
//    @GetMapping("/users/{id}")
//    public String getUserById(@PathVariable int id) {
//        return "사용자 정보";
//    }

//    @GetMapping("/users/{id}")
//    public String getUserById(
//            @Parameter(name = "id", description = "사용자 ID", required = true, example = "1")
//            @PathVariable int id
//    ) {
//        return "사용자 정보: " + id;
//    }

    @PostMapping("/users")
    public String createUser(
            @Parameter(description = "사용자 생성 정보", required = true)
            @io.swagger.v3.oas.annotations.media.Schema(example = "{ \"name\": \"홍길동\", \"email\": \"hong@example.com\" }")
            User user
    ) {
        return "사용자 생성: " + user.getName();

    }

    @ApiResponse(
            responseCode = "200",
            description = "성공적으로 반환",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
    )
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return new User(id, "홍길동", "hong@example.com");
    }

    // @Hidden
    // 특정 엔드포인트나 파라미터를 Swagger UI에서 숨김
    @Hidden
    @GetMapping("/admin")
    public String adminEndpoint() {
        return "관리자 전용 API";
    }

    // @SecurityRequirement
    // API의 인증/인가 요구 사항을 정의
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/secure-data")
    public String secureData() {
        return "인증된 사용자만 접근 가능";
    }
}
