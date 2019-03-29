package com.example.springstartertester.business.user.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String code;
}
