package com.meli.clase17youtuberblog.exception;

public class NonExistingBlogException extends RuntimeException{

    public NonExistingBlogException(String id) {
        super("The blog with id: " + id +" does not exist");
    }

    public NonExistingBlogException() {
        super("The blog does not exist");
    }
}
