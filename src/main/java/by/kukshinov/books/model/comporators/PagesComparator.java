package by.kukshinov.books.model.comporators;

import by.kukshinov.books.model.Book;

import java.util.Comparator;

public class PagesComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
	   int firstPages = first.getPages();
	   int pages = second.getPages();
	   return Integer.compare(firstPages, pages);
    }
}
