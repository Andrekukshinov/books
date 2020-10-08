package by.kukshinov.books.model.specefication.sort.impl;

import by.kukshinov.books.model.comporators.PublisherComparator;
import by.kukshinov.books.model.comporators.TitleComparator;
import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.specefication.sort.SortBookSpecification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TitleSort implements SortBookSpecification {
    @Override
    public List<Book> sort(List<Book> original) {
	   List<Book> finalBooks = new ArrayList<>(original);
	   Collections.sort(finalBooks, new TitleComparator());
	   return finalBooks;
    }
}