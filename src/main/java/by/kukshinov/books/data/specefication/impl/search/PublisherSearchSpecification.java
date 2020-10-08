package by.kukshinov.books.data.specefication.impl.search;

import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;
import by.kukshinov.books.data.specefication.SearchSpecification;

import java.util.ArrayList;
import java.util.List;

public class PublisherSearchSpecification extends SearchSpecification {

    @Override
    protected boolean matches(Book book, String value) {
	   return book.getPublisher().equalsIgnoreCase(value);
    }

    @Override
    protected ModelException throwException(String value) {
	   return new ModelException("Books published by " + value + " not found");
    }
}
