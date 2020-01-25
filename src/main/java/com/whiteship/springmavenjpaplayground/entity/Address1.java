package com.whiteship.springmavenjpaplayground.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address1 {
    // 집 주소 표현
    private String city;
    private String street;
    @Column
    private int zipCode;
}
