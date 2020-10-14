package by.kukshinov.books.data;

public class ParserException extends DataException {
    public ParserException(String message) {
	   super(message);
    }

    public ParserException(String message, Throwable cause) {
	   super(message, cause);
    }
}
