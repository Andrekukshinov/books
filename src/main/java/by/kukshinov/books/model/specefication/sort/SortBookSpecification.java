package by.kukshinov.books.model.specefication.sort;

import by.kukshinov.books.model.entity.Book;

import java.util.List;

public interface SortBookSpecification {
    List<Book> sort(List<Book> original);
}
