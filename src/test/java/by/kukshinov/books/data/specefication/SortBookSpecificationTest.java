package by.kukshinov.books.data.specefication;


import by.kukshinov.books.data.specefication.SortBookSpecification;
import by.kukshinov.books.model.comporators.AuthorComparator;
import by.kukshinov.books.model.comporators.PagesComparator;
import by.kukshinov.books.model.comporators.PublisherComparator;
import by.kukshinov.books.model.comporators.TitleComparator;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.BookType;
import by.kukshinov.books.data.specefication.impl.sort.AuthorSortSpecification;
import by.kukshinov.books.data.specefication.impl.sort.PagesSortSpecification;
import by.kukshinov.books.data.specefication.impl.sort.PublisherSortSpecification;
import by.kukshinov.books.data.specefication.impl.sort.TitleSortSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortBookSpecificationTest {

    private static final Book firstBook = new Book("J.K. Rowling", 324, "Harry Potter and Philosophy Stone", "Arsev", BookType.FANTASY);
    private static final Book secondBook = new Book("S. King", 956, "Green Mile", "Booka", BookType.FANTASY);
    private static final Book thirdBook = new Book("S. King", 324, "IT", "3DO", BookType.HORROR);
    private static final Book fourthBook = new Book("S. Spielberg", 575, "Jaws", "3DO", BookType.HORROR);
    private static final Book fifthBook = new Book("J.K. Rouwling", 324, "Harry Potter and Philosphy Stone", "Arsev", BookType.FANTASY);

    private static final List<Book> originalBooks = Arrays.asList(firstBook, secondBook, thirdBook, fourthBook, fifthBook);

    @Test
    public void shouldReturnSortedArrayPublisher() {
        //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SortBookSpecification publisherSort = new PublisherSortSpecification();
	   //when
	   List<Book> resultList = publisherSort.sort(startList);
	   //then
	   Collections.sort(startList, new PublisherComparator());
	   Assert.assertEquals(startList, resultList);
    }
    @Test
    public void shouldReturnSortedArrayPages() {
        //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SortBookSpecification publisherSort = new PagesSortSpecification();
	   //when
	   List<Book> resultList = publisherSort.sort(startList);
	   //then
	   Collections.sort(startList, new PagesComparator());
	   Assert.assertEquals(startList, resultList);
    }
    @Test
    public void shouldReturnSortedArrayTitle() {
        //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SortBookSpecification publisherSort = new TitleSortSpecification();
	   //when
	   List<Book> resultList = publisherSort.sort(startList);
	   //then
	   Collections.sort(startList, new TitleComparator());
	   Assert.assertEquals(startList, resultList);
    }
    @Test
    public void shouldReturnSortedArrayAuthor() {
        //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SortBookSpecification publisherSort = new AuthorSortSpecification();
	   //when
	   List<Book> resultList = publisherSort.sort(startList);
	   //then
	   Collections.sort(startList, new AuthorComparator());
	   Assert.assertEquals(startList, resultList);
    }

}
