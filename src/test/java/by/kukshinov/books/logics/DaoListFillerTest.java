package by.kukshinov.books.logics;


import by.kukshinov.books.data.SearchParam;
import by.kukshinov.books.data.access.BookDao;
import by.kukshinov.books.data.access.impl.ListBookDao;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.BookType;
import by.kukshinov.books.model.ModelException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DaoListFillerTest {
    private final List<Book> localBookStorage = new ArrayList<>();
    private final Book harryPotterRouwling = new Book("J.K. Rouwling", 324, "Harry Potter and Philosphy Stone", "Arsev", BookType.FANTASY);
    private final Book harryPotterRowling =new Book("J.K. Rowling", 324, "Harry Potter and Philosophy Stone", "Arsev", BookType.FANTASY);
    {
	   localBookStorage.add(harryPotterRowling);
	   localBookStorage.add(harryPotterRouwling);
    }
    @Test
    public void shouldFillGivenDao() throws ModelException {
        //given
	   DaoListFiller filler = new DaoListFiller();
	   BookDao dao = new ListBookDao();
	   List<Book> booksToCompare = new ArrayList<>(localBookStorage);
	   //then
	   filler.insertIntoDao(dao, booksToCompare);
	   //when
	   Assert.assertEquals(booksToCompare.size(), dao.getSize());
	   Assert.assertEquals(harryPotterRowling, dao.findBooks(SearchParam.AUTHOR, "J.K. Rowling").get(0));
    }
}
