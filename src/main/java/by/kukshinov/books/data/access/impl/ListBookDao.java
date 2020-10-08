package by.kukshinov.books.data.access.impl;

import by.kukshinov.books.data.access.BookDao;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;
import by.kukshinov.books.data.specefication.SearchSpecification;
import by.kukshinov.books.data.factory.SearchSpecificationCreator;
import by.kukshinov.books.data.SearchParam;
import by.kukshinov.books.data.specefication.SortBookSpecification;
import by.kukshinov.books.data.factory.SortSpecificationCreator;
import by.kukshinov.books.data.SortParam;

import java.util.ArrayList;
import java.util.List;

public class ListBookDao implements BookDao {
    private final List<Book> localBookStorage = new ArrayList<>();
    @Override
    public void addBook(Book book) {
        localBookStorage.add(book);
    }

    @Override
    public List<Book> findBooks(SearchParam param, String value) throws ModelException {
        SearchSpecificationCreator creator = new SearchSpecificationCreator();
        SearchSpecification searchSpecification = creator.createSearchSpecification(param);
	   return searchSpecification.findBook(localBookStorage, value);
    }

    @Override
    public void remove(Book book) throws ModelException {
        boolean result = localBookStorage.remove(book);
        if (result == false) {
            throw new ModelException("Book " + book + " doesn't exist");
        }
    }

    @Override
    public List<Book> sortArray(SortParam param) {
        SortSpecificationCreator creator = new SortSpecificationCreator();
        SortBookSpecification sortSpecification = creator.createSortSpecification(param);
	   return sortSpecification.sort(localBookStorage);
    }

    @Override
    public int getSize() {
        return localBookStorage.size();
    }
}
