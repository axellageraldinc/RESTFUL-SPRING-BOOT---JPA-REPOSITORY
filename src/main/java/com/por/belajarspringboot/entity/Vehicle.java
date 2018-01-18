package com.por.belajarspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "vehicle")
    private String vehicle;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
