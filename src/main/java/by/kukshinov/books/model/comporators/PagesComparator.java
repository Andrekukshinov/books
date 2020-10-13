package by.kukshinov.books.model.comporators;


import by.kukshinov.books.model.Book;

import java.util.Comparator;

public class PagesComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
	   return Integer.compare(o1.getPages(), o2.getPages());
    }
}
