package by.kukshinov.books.model.comporators;

import by.kukshinov.books.model.Book;

import java.util.Comparator;

public class AuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
	   String firstAuthor = o1.getAuthor();
	   String secondAuthor = o2.getAuthor();
	   return firstAuthor.compareTo(secondAuthor);
    }
}
