package com.example.jwt.service;

import com.example.jwt.jwt.JwtTokenProvider;
import com.example.jwt.mapper.AuthMapper;
import com.example.jwt.vo.JwtTokenVO;
import com.example.jwt.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private AuthMapper authMapper;
    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;

    public JwtTokenVO login(MemberVO memberVO) {
        UsernamePasswordAuthenticationToken authenticationToken = memberVO.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        JwtTokenVO jwtTokenVO = jwtTokenProvider.generateTokenDto(authentication);
        // refreshToken save
        return jwtTokenVO;
    }

    public MemberVO signup(MemberVO memberVO) {
        memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
        memberVO.setAuthority("ROLE_USER");
        authMapper.signup(memberVO);
        return memberVO;
    }

    public JwtTokenVO reissue(JwtTokenVO jwtTokenVO) {
        if (!jwtTokenProvider.validateToken(jwtTokenVO.getRefreshToken())) {
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }

        Authentication authentication = jwtTokenProvider.getAuthentication(jwtTokenVO.getAccessToken());

        // 저장소에서 refresh token 가져오기..

        // vo refresh token과 db refresh 토큰 문자열 비교.

        JwtTokenVO newJwtToken = jwtTokenProvider.generateTokenDto(authentication);

        // refresh token db save..

        return newJwtToken;
    }
}
