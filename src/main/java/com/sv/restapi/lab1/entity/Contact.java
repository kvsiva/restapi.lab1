package com.sv.restapi.lab1.entity;

import io.swagger.annotations.ApiModelProperty;

public class Contact {
    @ApiModelProperty(notes="The unique id of the contact")
    private String id;

    public Contact() {
    }

    public Contact(String id, String name, String address, int mobileNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }
    @ApiModelProperty(notes="The persons name")
    private String name;
    @ApiModelProperty(notes="The persons address")
    private String address;
    @ApiModelProperty(notes="The persons mobile number")
    private int mobileNumber;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
