package by.kukshinov.books.view.impl;


import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.view.DataPrinter;
import org.apache.log4j.Logger;

import java.util.List;

public class ConsoleDataPrinter implements DataPrinter {
    private static final Logger LOGGER = Logger.getLogger(ConsoleDataPrinter.class);

    @Override
    public void printData(Book book) {
	   LOGGER.info(book);
    }

    @Override
    public void printData(List<Book> books) {
	   for (int runner = 0; runner < books.size(); ++runner) {
		  printData(books.get(runner));
	   }
    }
}
