package Exceptions;

public class ItemCodeNotFoundException extends Exception {

    // Constructor with a custom error message
    public ItemCodeNotFoundException() {
        super("Item code not found.");
    }

    public ItemCodeNotFoundException(String message) {
        super(message);
    }

    public ItemCodeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
