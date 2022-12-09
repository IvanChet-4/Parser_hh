package com.example.Parser_hh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Resume_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String surname;
    int age;
    String position;
    String phone;
    String email;
    String url_site;
    LocalDateTime local_time;
    String was_time;

    public Resume_Entity() { }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUrl_site() {
        return url_site;
    }
    public void setUrl_site(String url_site) {
        this.url_site = url_site;
    }
    public LocalDateTime getLocal_time() {
        return local_time;
    }
    public void setLocal_time(LocalDateTime local_time) {
        this.local_time = local_time;
    }
    public String getWas_time() {
        return was_time;
    }
    public void setWas_time(String was_time) {
        this.was_time = was_time;
    }
}