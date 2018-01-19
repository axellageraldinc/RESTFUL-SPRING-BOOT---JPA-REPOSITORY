package com.por.belajarspringboot.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


/**
 *
 *
 * Class ini mengatur Response Standard untuk API call.
 * Jadi setiap API call itu nanti response-nya distandarisasi oleh WebResponse ini.
 * Isinya ada :
 *              1. code (200, 403, 404, dll)
 *              2. status (OK, NOT FOUND, BAD REQUEST, dll)
 *              3. data (berisi data, yaitu response yang diberikan, misal list semua person, detail satu person, dll)
 *
 *
 **/

@Data
@Builder
public class WebResponse<Response> {

    private Integer code;

    private String status;

    private Response data;

    public static <Response> WebResponse<Response> OK(Response data){
        return WebResponse.<Response>builder()
                .code(HttpStatus.OK.value())
                .status(HttpStatus.OK.getReasonPhrase())
                .data(data)
                .build();
    }

    public static <Response> WebResponse<Response> NOT_FOUND(){
        return WebResponse.<Response>builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
    }

}
