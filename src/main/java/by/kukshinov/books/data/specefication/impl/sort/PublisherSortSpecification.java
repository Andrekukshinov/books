package by.kukshinov.books.data.specefication.impl.sort;


import by.kukshinov.books.data.specefication.SortBookSpecification;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.comporators.PublisherComparator;

import java.util.Comparator;

public class PublisherSortSpecification extends SortBookSpecification {
    @Override
    protected Comparator<Book> getComparator() {
	   return new PublisherComparator();
    }
}
