package by.kukshinov.books.data;

import java.io.IOException;

public class DataException extends Exception {
    public DataException(String message) {
	   super(message);
    }

    public DataException(String message, Throwable cause) {
	   super(message, cause);
    }
}
