package by.kukshinov.books.data.acquirer;

import by.kukshinov.books.data.DataException;
import by.kukshinov.books.data.access.DaoException;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;

import java.io.IOException;
import java.util.List;

public interface DataAcquirer {
    List<Book> getBooks() throws IOException, DataException;
}
