package by.kukshinov.books.model.comporators;

import by.kukshinov.books.model.Book;

import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
	   String firstTitle = first.getTitle();
	   String secondTitle = second.getTitle();
	   return firstTitle.compareTo(secondTitle);
    }
}
