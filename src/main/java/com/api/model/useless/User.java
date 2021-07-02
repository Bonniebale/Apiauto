package com.api.model.useless;

import lombok.Data;

@Data

public class User {
//    private String companyName;
//    private String userName;
//    private String password;
    private String name;
    private String job;

//    public User(String companyName,String userName,String password){
//        super();
//        this.companyName = companyName;
//        this.userName = userName;
//        this.password = password;
//    }
    public User(){
        super();
    }
    public User(String name,String job){
        super();
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
