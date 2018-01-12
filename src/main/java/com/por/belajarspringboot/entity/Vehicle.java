package com.por.belajarspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "vehicle")
    private String vehicle;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Vehicle() {
    }

    public Vehicle(Person person, String vehicle) {
        this.person = person;
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
