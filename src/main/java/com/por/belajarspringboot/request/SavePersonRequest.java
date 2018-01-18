package com.por.belajarspringboot.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavePersonRequest {

    @NotBlank(message = "NotBlank")
    @Length(max = 30, message = "TooLong")
    private String name;

    @NotNull(message = "NotBlank")
    @Min(value = 0, message = "TooLow")
    private int age;

    private String address;
}
