package com.sprint1.be_java_hisp_w27_g04.exceptions;

public class NotInPromotion extends RuntimeException {

    public NotInPromotion(){
    }

    public NotInPromotion(String message){
        super(message);
    }
}
