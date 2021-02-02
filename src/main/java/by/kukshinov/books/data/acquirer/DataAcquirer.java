package by.kukshinov.books.data.acquirer;

import by.kukshinov.books.data.DataException;
import by.kukshinov.books.model.Book;

import java.util.List;

public interface DataAcquirer {
    List<Book> getBooks() throws DataException;
}
