package by.kukshinov.books.data.specefication.impl.sort;

import by.kukshinov.books.data.specefication.SortBookSpecification;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.comporators.PagesComparator;

import java.util.Comparator;

public class PagesSortSpecification extends SortBookSpecification {
    @Override
    protected Comparator<Book> getComparator() {
	   return new PagesComparator();
    }
}
