package com.por.belajarspringboot.response.person;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {

    private String name;

    private int age;

    private String address;

}
