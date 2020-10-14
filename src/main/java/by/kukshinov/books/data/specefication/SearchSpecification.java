package by.kukshinov.books.data.specefication;

import by.kukshinov.books.data.DataException;
import by.kukshinov.books.data.access.DaoException;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;

import java.util.ArrayList;
import java.util.List;

public abstract class SearchSpecification {

    protected abstract boolean matches(Book book, String value);

    protected abstract DaoException throwException(String value);

    public List<Book> findBook(List<Book> books, String value) throws DaoException {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (matches(book, value)) {
                result.add(book);
            }
        }
        if(result.size() > 0) {
            return result;
        }
        else throw throwException(value);
    }

}
//rework to delete repeating code
