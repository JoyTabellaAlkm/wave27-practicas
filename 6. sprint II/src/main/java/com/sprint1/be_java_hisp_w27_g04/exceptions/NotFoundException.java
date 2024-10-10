package com.sprint1.be_java_hisp_w27_g04.exceptions;

import java.io.IOException;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
