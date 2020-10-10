package by.kukshinov.books.data.specefication.impl.search;

import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;
import by.kukshinov.books.data.specefication.SearchSpecification;

import java.util.ArrayList;
import java.util.List;

public class PageSearcherSpecification extends SearchSpecification {
    private int parsePage(String page) {
        return Integer.parseInt(page);
    }

    @Override
    protected boolean matches(Book book, String value) {
        int pages = parsePage(value);
	   return book.getPages() == pages;
    }

    @Override
    protected ModelException throwException(String value) {
	   return new ModelException("Book with " + value + " pages not found");
    }
}
