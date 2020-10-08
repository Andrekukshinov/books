package by.kukshinov.books.view;

import by.kukshinov.books.model.entity.Book;

import java.util.List;

public interface DataPrinter {
    void printData(Book book);
    void printData(List<Book> books);
}
