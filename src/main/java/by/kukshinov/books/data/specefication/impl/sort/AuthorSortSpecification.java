package by.kukshinov.books.data.specefication.impl.sort;


import by.kukshinov.books.data.specefication.SortBookSpecification;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.comporators.AuthorComparator;

import java.util.Comparator;

public class AuthorSortSpecification extends SortBookSpecification {

    @Override
    protected Comparator<Book> getComparator() {
	   return new AuthorComparator();
    }
}


