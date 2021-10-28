package com.example.jwt.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class IndexMapper {
    @Autowired
    private SqlSession sqlSession;

    public List<Map<String, Object>> getMemberInfo() {
        return sqlSession.selectList("getMemberInfor");
    }
}
