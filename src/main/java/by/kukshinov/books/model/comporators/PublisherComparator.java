package by.kukshinov.books.model.comporators;

import by.kukshinov.books.model.Book;

import java.util.Comparator;

public class PublisherComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
	   String firstPublisher = first.getPublisher();
	   String secondPublisher = second.getPublisher();
	   return firstPublisher.compareTo(secondPublisher);
    }
}
