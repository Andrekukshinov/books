package by.kukshinov.books.model.specefication.search.impl;

import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.exception.NoSuchBookException;
import by.kukshinov.books.model.specefication.search.SearchBookSpecification;

import java.util.ArrayList;
import java.util.List;

public class PageSearcher implements SearchBookSpecification {
    public int parsePage(String page) {
        return Integer.parseInt(page);
    }
    @Override
    public List<Book> findBook(List<Book> books, String value) throws NoSuchBookException {
	   List<Book> result = new ArrayList<>();
	   for (Book book : books) {
		  if (book.getPages() == parsePage(value)) {
			 result.add(book);
		  }
	   }
	   if(result.size() > 0) {
		  return result;
	   }
	   else throw new NoSuchBookException("Book with " + value + " pages not found");
    }
}
