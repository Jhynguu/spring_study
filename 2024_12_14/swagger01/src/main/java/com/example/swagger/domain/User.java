package com.example.swagger.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "사용자 정보 모델")
public class User {
    @Schema(description = "사용자  ID", example = "1")
    private int id;

    @Schema(description = "사용자 이름", example = "홍길동")
    private String name;

    @Schema(description = "사용자 이메일", example = "hong@example.com")
    private String email;
}
