package com.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean implements Serializable{

    private Integer result;
    private Integer subCode;
    private String message;
    private Integer qTime;
    private Object data;
}
