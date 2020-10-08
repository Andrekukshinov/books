package by.kukshinov.books.appliction;

import by.kukshinov.books.data.acquirer.DataAcquirer;
import by.kukshinov.books.data.factory.DataAcquirerCreator;
import by.kukshinov.books.data.factory.impl.FileDataAcquirerCreator;
import by.kukshinov.books.model.data.access.BookDao;
import by.kukshinov.books.model.data.access.impl.ListBookDao;
import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.exception.NoSuchBookException;

import java.io.IOException;
import java.util.List;

import by.kukshinov.books.model.specefication.sort.factory.emuns.SortParam;
import by.kukshinov.books.view.DataPrinter;
import by.kukshinov.books.view.factory.DataPrinterFactory;
import by.kukshinov.books.view.factory.impl.FileDataPrinterFactory;
import org.apache.log4j.Logger;

public class BookApplication {
    private static final Logger LOGGER = Logger.getLogger(BookApplication.class);
    public static void main(String[] args){
        LOGGER.info("started");
        DataAcquirerCreator dataAcquirerCreator = new FileDataAcquirerCreator();
        DataAcquirer acquirer = dataAcquirerCreator.createDataAcquirer();
        BookDao bookDAO = new ListBookDao();
        try {
            run(acquirer, bookDAO);
        } catch (NoSuchBookException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }


    }

    private static void run(DataAcquirer acquirer, BookDao bookDAO) throws IOException, NoSuchBookException {
        Book bookForActions = acquirer.getData();
        bookDAO.addBook(bookForActions);
        List<Book> sortedListResult = bookDAO.sortArray(SortParam.AUTHOR);
        DataPrinterFactory dataPrinterFactory = new FileDataPrinterFactory();
        DataPrinter printer = dataPrinterFactory.createDataPrinter();
        printer.printData(sortedListResult);
        bookDAO.remove(bookForActions);
        sortedListResult = bookDAO.sortArray(SortParam.AUTHOR);
        printer.printData(sortedListResult);
    }
    // TODO: optional<FileDAO>
}
