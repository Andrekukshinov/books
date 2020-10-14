package by.kukshinov.books.data.access.impl;


import by.kukshinov.books.data.BookField;
import by.kukshinov.books.data.access.BookDao;
import by.kukshinov.books.data.access.DaoException;
import by.kukshinov.books.data.factory.SearchSpecificationCreator;
import by.kukshinov.books.data.factory.SortSpecificationCreator;
import by.kukshinov.books.data.specefication.SearchSpecification;
import by.kukshinov.books.data.specefication.SortBookSpecification;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;

import java.util.ArrayList;
import java.util.List;

public class ListBookDao implements BookDao {

    private final List<Book> localBookStorage = new ArrayList<>();

    private final SortSpecificationCreator sortSpecificationCreator;

    private final SearchSpecificationCreator searchSpecificationCreator;

    public ListBookDao(SortSpecificationCreator sortSpecificationCreator,
                       SearchSpecificationCreator searchSpecificationCreator) {
        this.sortSpecificationCreator = sortSpecificationCreator;
        this.searchSpecificationCreator = searchSpecificationCreator;
    }


    @Override
    public void addBook(Book book) throws DaoException {
        if (localBookStorage.contains(book)) {
            String stringBook = book.toString();
            String massage = String.format("Book %s already exists! ", stringBook);
            throw new DaoException(massage);
        }
        localBookStorage.add(book);
    }

    @Override
    public List<Book> findBooks(BookField param, String value) throws DaoException {
        SearchSpecification searchSpecification =
                searchSpecificationCreator.createSearchSpecification(param);
	   return searchSpecification.findBook(localBookStorage, value);
    }

    @Override
    public void remove(Book book) throws ModelException {
        boolean result = localBookStorage.remove(book);
        if (!result) {
            String stringBook = book.toString();
            String massage = String.format("Book %s doesn't exists! ", stringBook);
            throw new ModelException(massage);
        }
    }

    @Override
    public List<Book> sort(BookField param) {
        SortBookSpecification sortSpecification =
                sortSpecificationCreator.createSortSpecification(param);
	   return sortSpecification.sort(localBookStorage);
    }

    @Override
    public int getSize() {
        return localBookStorage.size();
    }
}
