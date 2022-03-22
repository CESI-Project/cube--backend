package com.svt.cube.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Consumer {
    @Id
    // ToDo: C'est quoi ?
    @SequenceGenerator(
            name = "consumer_sequence",
            sequenceName = "consumer_sequence",
            allocationSize = 1
    )
    // ToDo: C'est quoi ?
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "consumer_sequence"
    )
    private Integer id;
    private String firstName;
    private String name;
    private LocalDate birthDate;
    private String email;
    private String password;
    @Transient
    private Integer age;

    public Consumer() {
    }

    public Consumer(Integer id, String firstName, String name, LocalDate birthDate, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    public Consumer(String firstName, String name, LocalDate birthDate, String email, String password) {
        this.firstName = firstName;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age='" + 12 + '\'' +
                '}';
    }
}
