package by.kukshinov.books.model.data.access.impl;

import by.kukshinov.books.model.data.access.BookDao;
import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.enums.BookType;
import by.kukshinov.books.model.exception.NoSuchBookException;
import by.kukshinov.books.model.specefication.search.SearchBookSpecification;
import by.kukshinov.books.model.specefication.search.factory.SearchSpecificationCreator;
import by.kukshinov.books.model.specefication.search.factory.emuns.SearchParam;
import by.kukshinov.books.model.specefication.sort.SortBookSpecification;
import by.kukshinov.books.model.specefication.sort.factory.SortSpecificationCreator;
import by.kukshinov.books.model.specefication.sort.factory.emuns.SortParam;

import java.util.ArrayList;
import java.util.List;

public class ListBookDao implements BookDao {
    private final List<Book> localBookStorage = new ArrayList<>();
    {
        localBookStorage.add(new Book("J.K. Rowling", 324, "Harry Potter and Philosophy Stone", "Arsev", BookType.FANTASY));
        localBookStorage.add(new Book("S. King", 956, "Green Mile", "Booka", BookType.FANTASY));
        localBookStorage.add(new Book("S. King", 324, "IT", "3DO", BookType.HORROR));
        localBookStorage.add(new Book("S. Spielberg", 575, "Jaws", "3DO", BookType.HORROR));
        localBookStorage.add(new Book("J.K. Rouwling", 321, "Harry Potter and Philosphy Stone", "Arsev", BookType.FANTASY));
    }
    @Override
    public void addBook(Book book) {
        localBookStorage.add(book);
    }

    @Override
    public List<Book> findBooks(SearchParam param, String value) throws NoSuchBookException {
        SearchSpecificationCreator creator = new SearchSpecificationCreator();
        SearchBookSpecification searchSpecification = creator.createSearchSpecification(param);
	   return searchSpecification.findBook(localBookStorage, value);
    }

    @Override
    public void remove(Book book) throws NoSuchBookException {
        boolean result = localBookStorage.remove(book);
        if (result == false) {
            throw new NoSuchBookException("Book " + book + " doesn't exist");
        }
    }

    @Override
    public List<Book> sortArray(SortParam param) {
        SortSpecificationCreator creator = new SortSpecificationCreator();
        SortBookSpecification sortSpecification = creator.createSortSpecification(param);
	   return sortSpecification.sort(localBookStorage);
    }
}
