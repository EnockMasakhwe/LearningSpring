package com.eliarojr.springboot_practice_app.error;

public class InstitutionNotFoundException extends Exception{

    public InstitutionNotFoundException() {
        super();
    }

    public InstitutionNotFoundException(String message) {
        super(message);
    }

    public InstitutionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstitutionNotFoundException(Throwable cause) {
        super(cause);
    }

    protected InstitutionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
