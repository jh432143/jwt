package com.example.jwt.service;

import com.example.jwt.mapper.AuthMapper;
import com.example.jwt.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthMapper authMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberVO memberVO = authMapper.findMembers(username);

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(memberVO.getAuthority().toString());
        return new User(memberVO.getUsername(), memberVO.getPassword(), Collections.singleton(grantedAuthority));
    }
}
