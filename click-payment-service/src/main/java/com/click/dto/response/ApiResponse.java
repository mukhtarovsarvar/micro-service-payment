package com.click.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private String message;

    private Boolean status;

    private int statusCode;

    private T object;

    public ApiResponse(String message, Boolean status, int statusCode) {
        this.message = message;
        this.status = status;
        this.statusCode = statusCode;
    }

}
