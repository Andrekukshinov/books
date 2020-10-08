package by.kukshinov.books.data.acquirer;

import by.kukshinov.books.data.BookParser;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataAcquirer implements DataAcquirer {
    private final String filePath;
    private final BookParser parser;

    public FileDataAcquirer(String filePath, BookParser parser) {
	   this.filePath = filePath;
	   this.parser = parser;
    }

    private Book getData(String stringBook) throws ModelException {
		  return parser.parse(stringBook);
    }

    @Override
    public List<Book> getBooks() throws IOException, ModelException{
        List<Book> books = new ArrayList<>();
	   try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
	       String current;
	       while ((current = reader.readLine()) != null) {
	           Book currentBook = getData(current);
	           books.add(currentBook);
		  }
	   }
	   return books;
    }
}
