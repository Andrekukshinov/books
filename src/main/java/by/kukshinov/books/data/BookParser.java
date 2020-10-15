package by.kukshinov.books.data;

import by.kukshinov.books.model.Book;
import by.kukshinov.books.model.BookType;

import java.util.HashMap;
import java.util.Map;

public class BookParser {
    private static final String BOOK_PREFIX = "Book{";
    private static final String BOOK_AUTHOR = "author=";
    private static final String BOOK_PAGES = "pages=";
    private static final String BOOK_TITLE = "title=";
    private static final String BOOK_PUBLISHER = "publisher=";
    private static final String BOOK_TYPE = "type=";

    private int getDataLength(String stringBook) {
	   int runner = 0;
	   while (stringBook.charAt(runner) != ',' && (runner < stringBook.length() - 1)) {
		  ++runner;
	   }
	   return runner;
    }

    private String getStringBookData(String stringBook) {
	   int runner = getDataLength(stringBook);
	   return stringBook.substring(0, runner);
    }

    private void fillFieldData(String stringBook, Map<String, String> fieldData, String[] prefixesArray) {
	   for (String s : prefixesArray) {
		  if (stringBook.startsWith(s)) {
			 stringBook = stringBook.replace(s, "");
			 String key = s.substring(0, s.length() - 1);
			 fieldData.put(key, getStringBookData(stringBook));
			 stringBook = stringBook.replace(fieldData.get(key) + ", ", "");
		  }
	   }
    }

    private String getFiledName(String bookPrefix) {
	   return bookPrefix.substring(0, bookPrefix.length() - 1);
    }

    private String getFiledValue(Map<String, String> fieldData, String bookFieldPrefix) {
	   return fieldData.get(getFiledName(bookFieldPrefix));
    }


    public Book parse(String stringBook) throws ParserException {
	   if (!stringBook.startsWith(BOOK_PREFIX)) {
		  Book book =
				new Book("auth", 222, "tit", "publ", BookType.DETECTIVE);
		  String bookFormat = book.toString();
		  String massage = String.format("String %s doesn't match format %s", bookFormat, stringBook);
		  throw new ParserException(massage);
	   }
	   Map<String, String> fieldData = new HashMap<>();
	   String[] prefixesArray = new String[]{BOOK_AUTHOR, BOOK_PAGES, BOOK_TITLE, BOOK_PUBLISHER, BOOK_TYPE};

	   fillFieldData(stringBook.replace(BOOK_PREFIX, ""), fieldData, prefixesArray);

	   String author = getFiledValue(fieldData, BOOK_AUTHOR);
	   int pages = Integer.parseInt(getFiledValue(fieldData, BOOK_PAGES));
	   String title = getFiledValue(fieldData, BOOK_TITLE);
	   String publisher = getFiledValue(fieldData, BOOK_PUBLISHER);
	   BookType type = BookType.valueOf(getFiledValue(fieldData, BOOK_TYPE));

	   return new Book(author, pages, title, publisher, type);
    }

}
