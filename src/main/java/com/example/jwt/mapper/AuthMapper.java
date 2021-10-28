package com.example.jwt.mapper;

import com.example.jwt.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AuthMapper {
    @Autowired
    private SqlSession sqlSession;

    public Map<String, Object> getMemberInfo() {
        return sqlSession.selectOne("getMemberInfo");
    }

    public MemberVO findMember(String userName, String password) {
        return sqlSession.selectOne("getMemberInfo");
    }

    public MemberVO findMembers(String username) {
        return sqlSession.selectOne("findMembers", username);
    }

    public void signup(MemberVO memberVO) {
        sqlSession.insert("signup", memberVO);
    }
}
