package com.example.jwt.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserVO {
    private String EMAILSSS;
    private String NAMESSS;

    public UserVO(){}
}
