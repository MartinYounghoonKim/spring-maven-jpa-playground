package com.whiteship.springmavenjpaplayground.entity;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Period period;

    @Embedded
    private Address1 address1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Address1 getAddress1() {
        return address1;
    }

    public void setAddress1(Address1 address1) {
        this.address1 = address1;
    }

    public void setName(String name) {
        this.name = name;
    }

}
