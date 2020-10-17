package by.kukshinov.books.appliction;

import by.kukshinov.books.data.BookField;
import by.kukshinov.books.data.DataException;
import by.kukshinov.books.data.access.BookDao;
import by.kukshinov.books.data.access.impl.ListBookDao;
import by.kukshinov.books.data.acquirer.DataAcquirer;
import by.kukshinov.books.data.factory.DataAcquirerCreator;
import by.kukshinov.books.data.factory.SearchSpecificationCreator;
import by.kukshinov.books.data.factory.SortSpecificationCreator;
import by.kukshinov.books.data.factory.impl.FileDataAcquirerCreator;
import by.kukshinov.books.logics.DaoListFiller;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;
import by.kukshinov.books.view.DataPrinter;
import by.kukshinov.books.view.factory.DataPrinterFactory;
import by.kukshinov.books.view.factory.impl.FileDataPrinterFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class BookApplication {

    private static final Logger LOGGER = Logger
		  .getLogger(BookApplication.class);

    public static void main(String[] args) {
	   LOGGER.info("started");
	   DataAcquirerCreator dataAcquirerCreator = new FileDataAcquirerCreator();
	   DataAcquirer acquirer = dataAcquirerCreator.createDataAcquirer();
	   SearchSpecificationCreator searchSpecificationCreator = new SearchSpecificationCreator();
	   SortSpecificationCreator sortSpecificationCreator = new SortSpecificationCreator();
	   BookDao bookDAO = new ListBookDao(sortSpecificationCreator,
			 searchSpecificationCreator);
	   DaoListFiller filler = new DaoListFiller();
	   try {
		  run(acquirer, bookDAO, filler);
	   } catch (ModelException | DataException e) {
		  LOGGER.error(e.getMessage(), e);
	   }
    }

    private static void run(
		  DataAcquirer acquirer, BookDao bookDAO, DaoListFiller filler
    )throws ModelException, DataException {

	   List<Book> books = acquirer.getBooks();
	   Book bookForActions = books.get(1);
	   filler.insertIntoDao(bookDAO, books);
	   bookDAO.addBook(bookForActions);
	   List<Book> sortedListResult = bookDAO.sort(BookField.AUTHOR);
	   DataPrinterFactory dataPrinterFactory = new FileDataPrinterFactory();
	   DataPrinter printer = dataPrinterFactory.createDataPrinter();
	   printer.printData(sortedListResult);
	   bookDAO.remove(bookForActions);
	   bookDAO.remove(bookForActions);
	   bookDAO.remove(bookForActions);
	   sortedListResult = bookDAO.sort(BookField.AUTHOR);
	   printer.printData(sortedListResult);
    }
}
