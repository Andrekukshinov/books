package by.kukshinov.books.data.specefication.impl.search;

import by.kukshinov.books.data.specefication.SearchSpecification;
import by.kukshinov.books.model.Book;

public class TitleSearchSpecification extends SearchSpecification {

    @Override
    protected boolean matches(Book book, String value) {
	   String bookTitle = book.getTitle();
	   return bookTitle.equalsIgnoreCase(value);
    }

    @Override
    protected String getMassage(String value) {
	   return String.format("Book \"%s\" not found", value);
    }
}

