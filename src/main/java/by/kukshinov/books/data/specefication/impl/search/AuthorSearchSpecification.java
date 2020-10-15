package by.kukshinov.books.data.specefication.impl.search;

import by.kukshinov.books.data.access.DaoException;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;
import by.kukshinov.books.data.specefication.SearchSpecification;

import java.util.ArrayList;
import java.util.List;

public class AuthorSearchSpecification extends SearchSpecification {
    @Override
    protected boolean matches(Book book, String value) {
	   String bookAuthor = book.getAuthor();
	   return bookAuthor.equalsIgnoreCase(value);
    }

    @Override
    protected String getMassage(String value) {
	   return String.format("%s's book not found", value );
    }


}
