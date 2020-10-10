package by.kukshinov.books.view.impl;

import by.kukshinov.books.model.Book;
import by.kukshinov.books.view.DataPrinter;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileDataPrinter implements DataPrinter {
    private final String filePath;
	public static final Logger LOGGER = Logger.getLogger(FileDataPrinter.class);
    public FileDataPrinter(String filePath) {
	   this.filePath = filePath;
    }

    @Override
    public void printData(Book book) {
	   try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
		  writer.write(book.toString());
		  writer.write("\n");
	   } catch (IOException e) {
		  LOGGER.error(e.getMessage(), e);
	   }
    }

    @Override
    public void printData(List<Book> books) {
	   for (int runner = 0; runner < books.size(); ++runner) {
		  printData(books.get(runner));
	   }
    }
}
