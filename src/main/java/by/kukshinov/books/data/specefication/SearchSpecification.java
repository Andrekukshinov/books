package by.kukshinov.books.data.specefication;

import by.kukshinov.books.model.Book;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class SearchSpecification {

    private static final Logger LOGGER = Logger
		  .getLogger(SearchSpecification.class);

    protected abstract boolean matches(Book book, String value);

    protected abstract String getMassage(String value);

    public List<Book> findBook(List<Book> books, String value) {
	   List<Book> result = new ArrayList<>();
	   for (Book book : books) {
		  if (matches(book, value)) {
			 result.add(book);
		  }
	   }
	   if (result.size() == 0) {
		  LOGGER.warn(getMassage(value));
	   }
	   return result;
    }
}
