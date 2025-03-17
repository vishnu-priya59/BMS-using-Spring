package com.example.bookMyShow.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Theatre")
public class Theatre {

    @Id
    private String id;
    private String name;
    private String address;

    public Theatre(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString(){
        return "Theatre{title='"+name+ "', address:"+address+"}";
    }
}
