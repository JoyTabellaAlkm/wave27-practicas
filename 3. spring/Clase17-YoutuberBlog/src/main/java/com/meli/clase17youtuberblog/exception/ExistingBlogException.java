package com.meli.clase17youtuberblog.exception;

public class ExistingBlogException extends RuntimeException{
    public ExistingBlogException(String id) {
        super("The blog with id: " + id +" already exists");
    }

    public ExistingBlogException() {
        super("The blog already exists");
    }
}
