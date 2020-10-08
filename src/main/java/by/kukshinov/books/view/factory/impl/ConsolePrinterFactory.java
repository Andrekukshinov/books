package by.kukshinov.books.view.factory.impl;


import by.kukshinov.books.view.DataPrinter;
import by.kukshinov.books.view.factory.DataPrinterFactory;
import by.kukshinov.books.view.impl.ConsoleDataPrinter;

public class ConsolePrinterFactory implements DataPrinterFactory {
    @Override
    public DataPrinter createDataPrinter() {
	   return new ConsoleDataPrinter();
    }
}
