package by.kukshinov.books.view.factory.impl;


import by.kukshinov.books.view.DataPrinter;
import by.kukshinov.books.view.factory.DataPrinterFactory;
import by.kukshinov.books.view.impl.FileDataPrinter;

public class FileDataPrinterFactory implements DataPrinterFactory {
    private static final String FILE_PATH = "writeResultsFromDAO.txt";

    @Override
    public DataPrinter createDataPrinter() {
	   return new FileDataPrinter(FILE_PATH);
    }
}
