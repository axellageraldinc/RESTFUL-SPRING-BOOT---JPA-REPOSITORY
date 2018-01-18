package com.por.belajarspringboot.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveVehicleRequest {

    @NotBlank(message = "NotBlank")
    @Length(max = 30, message = "TooLong")
    private String vehicle;
}
