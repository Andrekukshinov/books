package by.kukshinov.books.data.specefication;

import by.kukshinov.books.data.specefication.SearchSpecification;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.BookType;
import by.kukshinov.books.model.ModelException;
import by.kukshinov.books.data.specefication.impl.search.AuthorSearchSpecification;
import by.kukshinov.books.data.specefication.impl.search.PageSearcherSpecification;
import by.kukshinov.books.data.specefication.impl.search.PublisherSearchSpecification;
import by.kukshinov.books.data.specefication.impl.search.TitleSearchSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchSpecificationTest {
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
    public void shouldReturnBookListByTitle() throws ModelException {
	   //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SearchSpecification titleSearch = new TitleSearchSpecification();
	   List<Book> toBeComparedWith = new ArrayList<>();
	   toBeComparedWith.add(bookToLook4InEveryTest);
	   //when
	   List<Book> resultList = titleSearch.findBook(startList, bookToLook4InEveryTest.getTitle());
	   //then
	   Assert.assertEquals(toBeComparedWith, resultList);
    }

    @Test
    public void shouldReturnBookListByPublisher() throws ModelException {
	   //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SearchSpecification publisherSearch = new PublisherSearchSpecification();
	   List<Book> toBeComparedWith = new ArrayList<>();
	   toBeComparedWith.add(bookToLook4NotTileAndAuthor);
	   toBeComparedWith.add(bookToLook4InEveryTest);
	   //when
	   List<Book> resultList = publisherSearch.findBook(startList, bookToLook4InEveryTest.getPublisher());
	   //then
	   Assert.assertEquals(toBeComparedWith, resultList);
    }
    @Test
    public void shouldReturnBookListByPages() throws ModelException {
	   //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SearchSpecification pageSearcher = new PageSearcherSpecification();
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
    public void shouldReturnBookListByAuthor() throws ModelException {
	   //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SearchSpecification authorSearch = new AuthorSearchSpecification();
	   List<Book> toBeComparedWith = new ArrayList<>();
	   toBeComparedWith.add(bookToLook4InEveryTest);
	   //when
	   List<Book> resultList = authorSearch.findBook(startList, bookToLook4InEveryTest.getAuthor());
	   //then
	   Assert.assertEquals(toBeComparedWith, resultList);
    }
}
