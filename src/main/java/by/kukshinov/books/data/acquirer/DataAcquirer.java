package by.kukshinov.books.data.acquirer;

import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;

import java.io.IOException;
import java.util.List;

public interface DataAcquirer {
//    Book getData() throws IOException, ModelException;
    List<Book> getBooks() throws IOException, ModelException;
}
