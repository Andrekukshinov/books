package by.kukshinov.books.data.specefication;


import by.kukshinov.books.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class SortBookSpecification {
    protected abstract Comparator<Book> getComparator();
    public List<Book> sort(List<Book> original){
        List<Book> finalBooks = new ArrayList<>(original);
        Collections.sort(finalBooks, getComparator());
        return finalBooks;
    }
}
