package by.kukshinov.books.model.specefication.search.impl;

import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.exception.NoSuchBookException;
import by.kukshinov.books.model.specefication.search.SearchBookSpecification;

import java.util.ArrayList;
import java.util.List;

public class AuthorSearch implements SearchBookSpecification {
    @Override
    public List<Book> findBook(List<Book> books, final String value) throws NoSuchBookException {
        List<Book> result = new ArrayList<>();
	   for (Book book : books) {
		  if (book.getAuthor().equalsIgnoreCase(value)) {
			 result.add(book);
		  }
	   }
	   if(result.size() > 0) {
		  return result;
	   }
	   else throw new NoSuchBookException(value + "'s books not found");
    }
}
