package by.kukshinov.books.data.acquirer.impl;

import by.kukshinov.books.data.acquirer.DataAcquirer;
import by.kukshinov.books.data.parser.BookParser;
import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.exception.NoSuchBookException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDataAcquirer implements DataAcquirer {
    private final String filePath;
    private final BookParser parser;

    public FileDataAcquirer(String filePath, BookParser parser) {
	   this.filePath = filePath;
	   this.parser = parser;
    }


    @Override
    public Book getData() throws IOException, NoSuchBookException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
		  String stringBook = reader.readLine();
		  return parser.parse(stringBook);
	   }
    }
}
