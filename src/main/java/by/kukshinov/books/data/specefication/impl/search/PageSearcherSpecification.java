package by.kukshinov.books.data.specefication.impl.search;

import by.kukshinov.books.data.specefication.SearchSpecification;
import by.kukshinov.books.model.Book;

public class PageSearcherSpecification extends SearchSpecification {

    @Override
    protected boolean matches(Book book, String value) {
	   int pages = Integer.parseInt(value);
	   return book.getPages() == pages;
    }

    @Override
    protected String getMassage(String value) {
	   return String.format("Book with %s pages not found.", value);
    }
}
