package by.kukshinov.books.model.comporators;

import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.enums.BookType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
	   return o1.getAuthor().compareTo(o2.getAuthor());
    }
}