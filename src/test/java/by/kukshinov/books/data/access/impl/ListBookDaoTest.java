package by.kukshinov.books.data.access.impl;

import by.kukshinov.books.data.SortParam;
import by.kukshinov.books.data.access.BookDao;
import by.kukshinov.books.logics.DaoListFiller;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.BookType;
import by.kukshinov.books.model.ModelException;
import by.kukshinov.books.model.comporators.TitleComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListBookDaoTest {
    private final List<Book> originalBooks = new ArrayList<>();
    private final Book potterRowling = new Book("J.K. Rowling", 324, "Harry Potter and Philosophy Stone", "Arsev", BookType.FANTASY);
    private final Book greenMile = new Book("S. King", 956, "Green Mile", "Booka", BookType.FANTASY);

    {
	   originalBooks.add(potterRowling);
    }
    //I'm not sure that that might be called as unit test, and by the way is it good 4 integration test?
    @Test
    public void shouldAddBookToDao() {
        //given
	   DaoListFiller filler = new DaoListFiller();
	   BookDao dao = new ListBookDao();
	   List<Book> booksToCompare = new ArrayList<>(originalBooks);
	   filler.insertIntoDao(dao, booksToCompare);
	   booksToCompare.add(greenMile);
	   Collections.sort(booksToCompare, new TitleComparator());
	   //when
	   dao.addBook(greenMile);
	   //then
	   List<Book> result = dao.sortArray(SortParam.TITLE);
	   Assert.assertEquals(booksToCompare, result);
	   Assert.assertEquals(booksToCompare.size(), dao.getSize());
    }
    @Test
    public void shouldRemoveBookFromDao() throws ModelException {
        //given
	   BookDao dao = new ListBookDao();
	   List<Book> booksToCompare = new ArrayList<>(originalBooks);
	   dao.addBook(potterRowling);
	   dao.addBook(greenMile);
	   Collections.sort(booksToCompare, new TitleComparator());
	   //when
	   dao.remove(greenMile);
	   //then
	   List<Book> result = dao.sortArray(SortParam.TITLE);
	   Assert.assertEquals(booksToCompare, result);
	   Assert.assertEquals(booksToCompare.size(), dao.getSize());
    }
}
