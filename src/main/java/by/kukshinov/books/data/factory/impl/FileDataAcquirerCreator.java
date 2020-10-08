package by.kukshinov.books.data.factory.impl;


import by.kukshinov.books.data.acquirer.DataAcquirer;
import by.kukshinov.books.data.acquirer.impl.FileDataAcquirer;
import by.kukshinov.books.data.factory.DataAcquirerCreator;
import by.kukshinov.books.data.parser.BookParser;

public class FileDataAcquirerCreator implements DataAcquirerCreator {
    private static final String FILE_PATH = "newBook.txt";
    private final BookParser parser = new BookParser();
    @Override
    public DataAcquirer createDataAcquirer() {
	   return new FileDataAcquirer(FILE_PATH, parser);
    }
}
