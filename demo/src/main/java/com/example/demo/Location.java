package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private Integer postCode;

    Location() {
    }

    ;

    public Location(String name, Integer postCode) {
        this.name = name;
        this.postCode = postCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + this.id + ", name='" + this.name + '\'' + ", postcode='" + this.postCode + '\'' + '}';
    }
}
