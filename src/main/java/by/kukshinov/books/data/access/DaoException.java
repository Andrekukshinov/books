package by.kukshinov.books.data.access;

import by.kukshinov.books.data.DataException;

public class DaoException extends DataException {

    public DaoException(String message) {
	   super(message);
    }

    public DaoException(String message, Throwable cause) {
	   super(message, cause);
    }
}
