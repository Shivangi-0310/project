package com.ttn.reap.DTO;

import java.util.HashMap;
import java.util.Map;

public class GenericResponse {

    String message;
    int status = 200;
    Map<String,Object> data = new HashMap<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
