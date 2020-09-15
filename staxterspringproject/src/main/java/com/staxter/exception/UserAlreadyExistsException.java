package com.staxter.exception;

public class UserAlreadyExistsException extends RuntimeException{

    private String code;
    private String description;

    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String code, String description) {

        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
