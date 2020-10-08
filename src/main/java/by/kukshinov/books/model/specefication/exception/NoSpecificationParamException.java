package by.kukshinov.books.model.specefication.exception;

public class NoSpecificationParamException extends RuntimeException {

    public NoSpecificationParamException(String message) {
	   super(message);
    }

    public NoSpecificationParamException(String message, Throwable cause) {
	   super(message, cause);
    }
}
