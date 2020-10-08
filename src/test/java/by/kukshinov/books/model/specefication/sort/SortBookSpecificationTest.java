package by.kukshinov.books.model.specefication.sort;


import by.kukshinov.books.model.comporators.AuthorComparator;
import by.kukshinov.books.model.comporators.PagesComparator;
import by.kukshinov.books.model.comporators.PublisherComparator;
import by.kukshinov.books.model.comporators.TitleComparator;
import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.enums.BookType;
import by.kukshinov.books.model.specefication.sort.SortBookSpecification;
import by.kukshinov.books.model.specefication.sort.impl.AuthorSort;
import by.kukshinov.books.model.specefication.sort.impl.PagesSort;
import by.kukshinov.books.model.specefication.sort.impl.PublisherSort;
import by.kukshinov.books.model.specefication.sort.impl.TitleSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortBookSpecificationTest {
    private final List<Book> originalBooks = new ArrayList<>();
    {
	   originalBooks.add(new Book("J.K. Rowling", 324, "Harry Potter and Philosophy Stone", "Arsev", BookType.FANTASY));
	   originalBooks.add(new Book("S. King", 956, "Green Mile", "Booka", BookType.FANTASY));
	   originalBooks.add(new Book("S. King", 324, "IT", "3DO", BookType.HORROR));
	   originalBooks.add(new Book("S. Spielberg", 575, "Jaws", "3DO", BookType.HORROR));
	   originalBooks.add(new Book("J.K. Rouwling", 324, "Harry Potter and Philosphy Stone", "Arsev", BookType.FANTASY));
    }
    @Test
    public void shouldReturnSortedArrayPublisher() {
        //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SortBookSpecification publisherSort = new PublisherSort();
	   //when
	   List<Book> resultList = publisherSort.sort(startList);
	   //then
	   startList.sort(new PublisherComparator());
	   Assert.assertEquals(startList, resultList);
    }
    @Test
    public void shouldReturnSortedArrayPages() {
        //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SortBookSpecification publisherSort = new PagesSort();
	   //when
	   List<Book> resultList = publisherSort.sort(startList);
	   //then
	   startList.sort(new PagesComparator());
	   Assert.assertEquals(startList, resultList);
    }
    @Test
    public void shouldReturnSortedArrayTitle() {
        //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SortBookSpecification publisherSort = new TitleSort();
	   //when
	   List<Book> resultList = publisherSort.sort(startList);
	   //then
	   startList.sort(new TitleComparator());
	   Assert.assertEquals(startList, resultList);
    }
    @Test
    public void shouldReturnSortedArrayAuthor() {
        //given
	   List<Book> startList = new ArrayList<>(originalBooks);
	   SortBookSpecification publisherSort = new AuthorSort();
	   //when
	   List<Book> resultList = publisherSort.sort(startList);
	   //then
	   startList.sort(new AuthorComparator());
	   Assert.assertEquals(startList, resultList);
    }

}
