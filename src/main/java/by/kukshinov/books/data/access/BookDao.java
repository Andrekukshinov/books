package by.kukshinov.books.data.access;

import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;
import by.kukshinov.books.data.SearchParam;
import by.kukshinov.books.data.SortParam;

import java.util.List;

public interface BookDao {
    //unique book obj
    void addBook(Book book);
    List<Book> findBooks(SearchParam searchParam, String value) throws ModelException;
    void remove(Book book) throws ModelException;
    List<Book> sortArray(SortParam sortParam);
    int getSize();
}
