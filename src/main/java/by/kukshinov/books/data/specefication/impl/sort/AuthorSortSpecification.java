package by.kukshinov.books.data.specefication.impl.sort;

import by.kukshinov.books.model.comporators.AuthorComparator;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.data.specefication.SortBookSpecification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AuthorSortSpecification extends SortBookSpecification {

    @Override
    protected Comparator<Book> getComparator() {
	   return new AuthorComparator();
    }
}

