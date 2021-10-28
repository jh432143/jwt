package com.example.jwt.service;

import com.example.jwt.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IndexService {
    @Autowired
    private IndexMapper indexMapper;

    public List<Map<String, Object>> getMemberInfo() {
        return indexMapper.getMemberInfo();
    }
}
