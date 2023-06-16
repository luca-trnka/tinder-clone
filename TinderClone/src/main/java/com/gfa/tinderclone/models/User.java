package com.gfa.tinderclone.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate birth_date;
    private int age;
    private String gender;
    private String bio;

    public User() {
    }

    public User(String name, String gender, LocalDate birth_date, String bio) {
        this.name = name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.bio = bio;
    }

    public int AgeCalculator(LocalDate birth_date) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(birth_date, now);
        return period.getYears();
    }

    public int getAge() {
        return AgeCalculator(getBirth_date());
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
