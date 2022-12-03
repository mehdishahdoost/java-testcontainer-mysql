package com.github.mehdishahdoost.testcontainer.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_person")
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
