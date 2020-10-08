package by.kukshinov.books.data.acquirer;

import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.exception.NoSuchBookException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataAcquirer {
    Book getData() throws IOException, NoSuchBookException;
}
