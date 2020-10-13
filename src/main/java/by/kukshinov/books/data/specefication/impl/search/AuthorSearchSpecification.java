package by.kukshinov.books.data.specefication.impl.search;


import by.kukshinov.books.data.specefication.SearchSpecification;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;


public class AuthorSearchSpecification extends SearchSpecification {
    @Override
    protected boolean matches(Book book, String value) {
	   return book.getAuthor().equalsIgnoreCase(value);
    }

    @Override
    protected ModelException throwException(String value) {
	   return new ModelException(value + "'s book not found");
    }
}
