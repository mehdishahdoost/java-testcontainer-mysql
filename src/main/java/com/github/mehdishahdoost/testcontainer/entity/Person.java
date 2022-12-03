package com.github.mehdishahdoost.testcontainer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_person")
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
