package by.kukshinov.books.data.specefication.impl.search;

import by.kukshinov.books.data.specefication.SearchSpecification;
import by.kukshinov.books.model.Book;

public class PublisherSearchSpecification extends SearchSpecification {

    @Override
    protected boolean matches(Book book, String value) {
	   String bookPublisher = book.getPublisher();
	   return bookPublisher.equalsIgnoreCase(value);
    }

    @Override
    protected String getMassage(String value) {
	   return String.format("Books published by %s not found", value);
    }
}
