package com.por.belajarspringboot.request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SavePersonRequest {

    @NotBlank(message = "Name cannot be empty!")
    @Length(max = 30, message = "Name too long! Max 30 characters")
    private String name;

    @NotNull(message = "Age cannot be empty!")
    @Min(value = 0, message = "Minimum age value is 0!")
    private int age;

    private String address;

    public SavePersonRequest() {
    }

    public SavePersonRequest(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
