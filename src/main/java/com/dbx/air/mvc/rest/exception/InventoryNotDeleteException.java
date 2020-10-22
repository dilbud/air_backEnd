package com.dbx.air.mvc.rest.exception;

public class InventoryNotDeleteException extends RuntimeException{
    public InventoryNotDeleteException() {
        super();
    }

    public InventoryNotDeleteException(String message) {
        super(message);
    }

    public InventoryNotDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public InventoryNotDeleteException(Throwable cause) {
        super(cause);
    }
}
