package com.example.jwt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class MemberVO {
    @Schema(description = "이메일")
    private String username;

    @Schema(description = "비밀번호")
    private String password;

    @Schema(description = "권한")
    private String authority;

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
