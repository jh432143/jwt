package com.example.jwt.controller;

import com.example.jwt.service.IndexService;
import com.example.jwt.vo.UserVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/")
    public Map<String, Object> index () {
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> memberInfo = indexService.getMemberInfo();

        System.out.println("memberInfo :::::::: "+memberInfo.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        List<UserVO> userVO = objectMapper.convertValue(memberInfo, List.class);
        System.out.println("userVO ::::::: "+userVO.toString());

        result.put("memberInfo", memberInfo);
        result.put("code", "0000");
        return result;
    }
}
