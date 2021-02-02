package by.kukshinov.books.data.access;

import by.kukshinov.books.data.BookField;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;

import java.util.List;

public interface BookDao {

    void addBook(Book book) throws DaoException;

    List<Book> findBooks(BookField searchParam, String value);

    void remove(Book book) throws ModelException;

    List<Book> sort(BookField sortParam);

    int getSize();
}
