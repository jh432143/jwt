package com.example.jwt.controller;

import com.example.jwt.service.AuthService;
import com.example.jwt.vo.JwtTokenVO;
import com.example.jwt.vo.MemberVO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @Operation(summary = "회원가입", description = "회원가입정보등록")
    public Map<String, Object> signup (@RequestBody MemberVO memberVO) {
        System.out.println("signup start........"+memberVO.toString());
        Map<String, Object> result = new HashMap<>();

        memberVO = authService.signup(memberVO);

        result.put("memberVO", memberVO);
        result.put("code", "1111");
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Operation(summary = "로그인", description = "로그인")
    public Map<String, Object> login (@RequestBody MemberVO memberVO) {
        System.out.println("login start........"+memberVO.toString());
        Map<String, Object> result = new HashMap<>();

        JwtTokenVO jwtTokenVO = authService.login(memberVO);

        result.put("jwtTokenVO", jwtTokenVO);
        result.put("code", "1111");
        return result;
    }

    @RequestMapping(value = "/reissue", method = RequestMethod.POST)
    @Operation(summary = "토큰재발급", description = "토큰재발급")
    public Map<String, Object> reissue (@RequestBody JwtTokenVO jwtTokenVO) {
        System.out.println("login start........"+jwtTokenVO.toString());
        Map<String, Object> result = new HashMap<>();

        JwtTokenVO newJwtToken = authService.reissue(jwtTokenVO);

        result.put("jwtTokenVO", newJwtToken);
        result.put("code", "1111");
        return result;
    }
}
