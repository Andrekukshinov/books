package by.kukshinov.books.model.data.access;

import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.exception.NoSuchBookException;
import by.kukshinov.books.model.specefication.search.factory.emuns.SearchParam;
import by.kukshinov.books.model.specefication.sort.factory.emuns.SortParam;

import java.util.List;

public interface BookDao {
    //unique book obj
    void addBook(Book book);
    List<Book> findBooks(SearchParam searchParam, String value) throws NoSuchBookException;
    void remove(Book book) throws NoSuchBookException;
    List<Book> sortArray(SortParam sortParam);
}
