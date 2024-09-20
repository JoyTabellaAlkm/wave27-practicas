package org.example.youtuberblog_ejercicio.exceptions;

public class BlogDoesntExist extends Exception {
    public BlogDoesntExist() {
        super("Blog does not exist");
    }
}
