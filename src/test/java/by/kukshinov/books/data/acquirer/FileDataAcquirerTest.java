package by.kukshinov.books.data.acquirer;


import by.kukshinov.books.data.BookParser;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.BookType;
import by.kukshinov.books.model.ModelException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataAcquirerTest {
    public final String filePath = "src/test/resources/testStorage.txt";
    private final List<Book> localBookStorage = new ArrayList<>();
    private final Book potterRowling = new Book("J.K. Rowling", 324, "Harry Potter and Philosophy Stone", "Arsev", BookType.FANTASY);
    private final Book greenMile = new Book("S. King", 956, "Green Mile", "Booka", BookType.FANTASY);
    private final Book it = new Book("S. King", 324, "IT", "3DO", BookType.HORROR);
    private final Book jaws = new Book("S. Spielberg", 575, "Jaws", "3DO", BookType.HORROR);
    private final Book potterRouling = new Book("J.K. Rouwling", 324, "Harry Potter and Philosphy Stone", "Arsev", BookType.FANTASY);

    {
	   localBookStorage.add(potterRowling);
	   localBookStorage.add(greenMile);
	   localBookStorage.add(it);
	   localBookStorage.add(jaws);
	   localBookStorage.add(potterRouling);
    }
    @Test
    public void shouldReadDataFromFileAndReturnBooksList() throws IOException, ModelException {
        //given
	   BookParser parser = new BookParser();
	   DataAcquirer fileDataAcquirer = new FileDataAcquirer(filePath, parser);
	   List<Book> booksToCompare = new ArrayList<>(localBookStorage);
	   //when
	   List<Book> result = fileDataAcquirer.getBooks();
	   //then
	   Assert.assertEquals(booksToCompare, result);
    }
}
