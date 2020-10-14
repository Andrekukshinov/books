package by.kukshinov.books.data.specefication.impl.search;

import by.kukshinov.books.data.access.DaoException;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;
import by.kukshinov.books.data.specefication.SearchSpecification;

import java.util.ArrayList;
import java.util.List;

public class TitleSearchSpecification extends SearchSpecification {

    @Override
    protected boolean matches(Book book, String value) {
	   String bookTitle = book.getTitle();
	   return bookTitle.equalsIgnoreCase(value);
    }

    @Override
    protected DaoException throwException(String value) {
	   return new DaoException("Book \"" + value + "\"" + " not found");
    }
}

