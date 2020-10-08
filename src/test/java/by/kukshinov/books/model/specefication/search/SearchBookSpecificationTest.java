package by.kukshinov.books.model.specefication.search;

import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.enums.BookType;
import by.kukshinov.books.model.exception.NoSuchBookException;
import by.kukshinov.books.model.specefication.search.impl.AuthorSearch;
import by.kukshinov.books.model.specefication.search.impl.PageSearcher;
import by.kukshinov.books.model.specefication.search.impl.PublisherSearch;
import by.kukshinov.books.model.specefication.search.impl.TitleSearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchBookSpecificationTest  {
    private final List<Book> originalBooks = new ArrayList<>();
    {
	   originalBooks.add(new Book("J.K. Rowling", 324, "Harry Potter and Philosophy Stone", "Arsev", BookType.FANTASY));
	   originalBooks.add(new Book("S. King", 956, "Green Mile", "Booka", BookType.FANTASY));
	   originalBooks.add(new Book("S. King", 324, "IT", "3DO", BookType.HORROR));
	   originalBooks.add(new Book("S. Spielberg", 575, "Jaws", "3DO", BookType.HORROR));
	   originalBooks.add(new Book("J.K. Rouwling", 324, "Harry Potter and Philosphy Stone", "Arsev", BookType.FANTASY));
    }
    private final Book bookToLook4InEveryTest = new Book("J.K. Rouwling", 324, "Harry Potter and Philosphy Stone", "Arsev", BookType.FANTASY);
    private final Book bookToLook4NotTileAndAuthor = new Book("J.K. Rowling", 324, "Harry Potter and Philosophy Stone", "Arsev", BookType.FANTASY);
    private final Book bookToLook4ByPages = new Book("S. King", 324, "IT", "3DO", BookType.HORROR);
    @Test
    public void shouldReturnBookListByTitle() throws NoSuchBookException {
	   //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SearchBookSpecification titleSearch = new TitleSearch();
	   List<Book> toBeComparedWith = new ArrayList<>();
	   toBeComparedWith.add(bookToLook4InEveryTest);
	   //when
	   List<Book> resultList = titleSearch.findBook(startList, bookToLook4InEveryTest.getTitle());
	   //then
	   Assert.assertEquals(toBeComparedWith, resultList);
    }

    @Test
    public void shouldReturnBookListByPublisher() throws NoSuchBookException {
	   //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SearchBookSpecification publisherSearch = new PublisherSearch();
	   List<Book> toBeComparedWith = new ArrayList<>();
	   toBeComparedWith.add(bookToLook4NotTileAndAuthor);
	   toBeComparedWith.add(bookToLook4InEveryTest);
	   //when
	   List<Book> resultList = publisherSearch.findBook(startList, bookToLook4InEveryTest.getPublisher());
	   //then
	   Assert.assertEquals(toBeComparedWith, resultList);
    }
    @Test
    public void shouldReturnBookListByPages() throws NoSuchBookException {
	   //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SearchBookSpecification pageSearcher = new PageSearcher();
	   List<Book> toBeComparedWith = new ArrayList<>();
	   toBeComparedWith.add(bookToLook4NotTileAndAuthor);
	   toBeComparedWith.add(bookToLook4ByPages);
	   toBeComparedWith.add(bookToLook4InEveryTest);
	   //when
	   List<Book> resultList = pageSearcher.findBook(startList, String.valueOf(bookToLook4InEveryTest.getPages()));
	   //then
	   Assert.assertEquals(toBeComparedWith, resultList);
    }
    @Test
    public void shouldReturnBookListByAuthor() throws NoSuchBookException {
	   //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SearchBookSpecification authorSearch = new AuthorSearch();
	   List<Book> toBeComparedWith = new ArrayList<>();
	   toBeComparedWith.add(bookToLook4InEveryTest);
	   //when
	   List<Book> resultList = authorSearch.findBook(startList, bookToLook4InEveryTest.getAuthor());
	   //then
	   Assert.assertEquals(toBeComparedWith, resultList);
    }
}
