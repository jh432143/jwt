package com.example.jwt.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @Operation(summary = "유저정보", description = "유저정보")
    public Map<String, Object> userInfo () {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "2222");
        return result;
    }
}
