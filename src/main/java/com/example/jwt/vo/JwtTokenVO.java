package com.example.jwt.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtTokenVO {
    private String tokenType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresIn;
}
