package com.africa.semicolon.wazobia_app.dtos.response;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ApiResponse {
    private Object data;
    private boolean isSucessfull;

    public boolean isSucessfull() {
        return isSucessfull;
    }

    public void setSucessfull(boolean sucessfull) {
        isSucessfull = sucessfull;
    }

    public ApiResponse(boolean isSucessfull, Object data) {
        this.isSucessfull = isSucessfull;
        this.data = data;
    }




}
