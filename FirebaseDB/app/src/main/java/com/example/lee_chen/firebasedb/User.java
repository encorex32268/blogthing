package com.example.lee_chen.firebasedb;

public class User {
    private int index;
    private String guid;
    private boolean isActive;
    private String balance;
    private String picture;
    private int age;
    private String eyecolor;
    private String name ;
    private String gender;
    private String company;
    private String email;
    private String phone ;
    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "index=" + index +
                ", guid='" + guid + '\'' +
                ", isActive=" + isActive +
                ", balance='" + balance + '\'' +
                ", picture='" + picture + '\'' +
                ", age=" + age +
                ", eyecolor='" + eyecolor + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }



    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
