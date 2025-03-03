package com.example.bookMyShow.entity;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
    @Setter
    @Id
    private String id;
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    @Indexed(unique = true)
    private String email;
    @Setter
    private String phone;


    public User(String id,String username,String password,String email, String phone){
        this.id=id;
        this.username=username;
        this.password=password;
        this.email=email;
        this.phone=phone;
    }

    public String getId(){ return id; }
    public String getUsername(){ return username; }
    public String getPassword(){ return password; }
    public String getEmail(){ return email;}
    public String getPhone(){ return phone; }

}
