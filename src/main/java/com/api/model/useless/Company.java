package com.api.model.useless;

import lombok.Data;

@Data
public class Company {
    private String companyName;
    private String userName;
    private String password;
    public Company(){
        super();
    }
    public Company(String companyName, String userName, String password){
        super();
        this.companyName = companyName;
        this.userName = userName;
        this.password = password;
    }

}
