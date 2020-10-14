package by.kukshinov.books.appliction;

import by.kukshinov.books.data.acquirer.DataAcquirer;
import by.kukshinov.books.data.factory.DataAcquirerCreator;
import by.kukshinov.books.data.factory.impl.FileDataAcquirerCreator;
import by.kukshinov.books.data.access.BookDao;
import by.kukshinov.books.data.access.impl.ListBookDao;
import by.kukshinov.books.logics.DaoListFiller;
import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.ModelException;

import java.io.IOException;
import java.util.List;

import by.kukshinov.books.data.SortParam;
import by.kukshinov.books.view.DataPrinter;
import by.kukshinov.books.view.factory.DataPrinterFactory;
import by.kukshinov.books.view.factory.impl.FileDataPrinterFactory;
import org.apache.log4j.Logger;

public class BookApplication {
    private static final Logger LOGGER =
            Logger.getLogger(BookApplication.class);

    public static void main(String[] args){
        LOGGER.info("started");
        DataAcquirerCreator dataAcquirerCreator = new FileDataAcquirerCreator();
        DataAcquirer acquirer = dataAcquirerCreator.createDataAcquirer();
        BookDao bookDAO = new ListBookDao();
        DaoListFiller filler = new DaoListFiller();
        try {
            run(acquirer, bookDAO, filler);
        } catch (ModelException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private static void run(DataAcquirer acquirer, BookDao bookDAO, DaoListFiller filler) throws IOException, ModelException {
        List<Book> books = acquirer.getBooks();
        Book bookForActions = books.get(1);
        filler.insertIntoDao(bookDAO, books);
        bookDAO.addBook(bookForActions);
        List<Book> sortedListResult = bookDAO.sortArray(SortParam.AUTHOR);
        DataPrinterFactory dataPrinterFactory = new FileDataPrinterFactory();
        DataPrinter printer = dataPrinterFactory.createDataPrinter();
        printer.printData(sortedListResult);
        bookDAO.remove(bookForActions);
        bookDAO.remove(bookForActions);
        bookDAO.remove(bookForActions);
        sortedListResult = bookDAO.sortArray(SortParam.AUTHOR);
        printer.printData(sortedListResult);
    }
}
