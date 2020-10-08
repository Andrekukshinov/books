package by.kukshinov.books.model.comporators;

import by.kukshinov.books.model.entity.Book;

import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
	   return o1.getTitle().compareTo(o2.getTitle());
    }
}
