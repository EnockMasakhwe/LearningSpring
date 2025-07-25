package com.eliarojr.job_app_backend.error;

public class JobNotFoundException extends Exception{
    protected JobNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public JobNotFoundException(Throwable cause) {
        super(cause);
    }

    public JobNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobNotFoundException(String message) {
        super(message);
    }

    public JobNotFoundException() {
        super();
    }
}
