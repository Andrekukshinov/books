package by.kukshinov.books.logics;

import by.kukshinov.books.data.access.BookDao;
import by.kukshinov.books.data.access.DaoException;
import by.kukshinov.books.model.Book;
import org.apache.log4j.Logger;

import java.util.List;

public class DaoListFiller {
    private static final Logger LOGGER = Logger.getLogger(DaoListFiller.class);

    public void insertIntoDao(BookDao dao, List<Book> books) {
	   for (Book book : books) {
		  try {
			 dao.addBook(book);
		  } catch (DaoException e) {
			 LOGGER.error(e);
		  }
	   }
    }
}

