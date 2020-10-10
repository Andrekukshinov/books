package by.kukshinov.books.data.parser;

import by.kukshinov.books.data.BookParser;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.BookType;
import by.kukshinov.books.model.ModelException;
import org.junit.Assert;
import org.junit.Test;

public class BookParserTest {
    private final String bookString = "Book{author=Rowling, pages=234, title=Harry Potter and Phil stone, publisher=arsev, type=FANTASY}";
    private final Book book = new Book("Rowling", 234, "Harry Potter and Phil stone", "arsev", BookType.FANTASY);

    @Test
    public void shouldParseStringDataOfSpecifiedFormatToBook() throws ModelException {
	   //given
	   String localBookString = bookString;
	   BookParser parser = new BookParser();
	   //when
	   Book resBook = parser.parse(localBookString);
	   //then

	   Assert.assertEquals(book, resBook);

    }
}
