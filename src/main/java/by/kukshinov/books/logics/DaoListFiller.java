package by.kukshinov.books.logics;

import by.kukshinov.books.data.access.BookDao;
import by.kukshinov.books.model.Book;

import java.util.List;

public class DaoListFiller {
    public void insertIntoDao(BookDao dao, List<Book> books) {
	   for (Book book: books) {
		  dao.addBook(book);
	   }
    }
}
