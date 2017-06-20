package com.exception;

public class StorageException extends RuntimeException {
    public String getUuid() {
        return uuid;
    }

    private final String uuid;

    public StorageException(String message) {
        this(message,null,null);
    }

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public StorageException(String message, String uuid, Exception e) {
        super(message, e);
        this.uuid = uuid;
    }

}
