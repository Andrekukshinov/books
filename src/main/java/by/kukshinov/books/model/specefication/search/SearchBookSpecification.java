package by.kukshinov.books.model.specefication.search;

import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.exception.NoSuchBookException;

import java.util.List;

public interface SearchBookSpecification {
    List<Book> findBook(List<Book> books, String value) throws NoSuchBookException;
}
//rework to delete repeating code
