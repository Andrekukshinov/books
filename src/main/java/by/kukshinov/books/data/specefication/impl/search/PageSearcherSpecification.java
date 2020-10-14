package by.kukshinov.books.data.specefication.impl.search;

import by.kukshinov.books.data.access.DaoException;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;
import by.kukshinov.books.data.specefication.SearchSpecification;

import java.util.ArrayList;
import java.util.List;

public class PageSearcherSpecification extends SearchSpecification {

    @Override
    protected boolean matches(Book book, String value) {
        int pages = Integer.parseInt(value);;
	   return book.getPages() == pages;
    }

    @Override
    protected DaoException throwException(String value) {
	   return new DaoException("Book with " + value + " pages not found");
    }
}
