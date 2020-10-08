package by.kukshinov.books.data.parser;

import by.kukshinov.books.model.entity.Book;
import by.kukshinov.books.model.enums.BookType;
import by.kukshinov.books.model.exception.NoSuchBookException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.RandomAccess;

public class BookParser {
    private final String bookPrefix = "Book{";
    private final String bookAuthor = "author=";
    private final String bookPages = "pages=";
    private final String bookTitle = "title=";
    private final String bookPublisher = "publisher=";
    private final String bookType = "type=";

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


    public Book parse(String stringBook) throws NoSuchBookException {
	   if (!stringBook.startsWith(bookPrefix)) {
		  throw new NoSuchBookException("String " + stringBook + " doesn't match format " + new Book("auth", 222, "tit", "publ", BookType.DETECTIVE).toString());
	   }
	   Map<String, String> fieldData = new HashMap<>();
	   String[] prefixesArray = new String[]{bookAuthor, bookPages, bookTitle, bookPublisher, bookType};

	   fillFieldData(stringBook.replace(bookPrefix, ""), fieldData, prefixesArray);

	   String author = getFiledValue(fieldData, bookAuthor);
	   int pages = Integer.parseInt(getFiledValue(fieldData, bookPages));
	   String title = getFiledValue(fieldData, bookTitle);
	   String publisher = getFiledValue(fieldData, bookPublisher);
	   BookType type = BookType.valueOf(getFiledValue(fieldData, bookType));

	   return new Book(author, pages, title, publisher, type);
    }

}


//class N {
//    public static void main(String[] args) throws IOException {
//	   BufferedReader reader = new BufferedReader(new FileReader("tst.txt"));
//	   RandomAccessFile access = new RandomAccessFile("tst.txt", "rw");
//	   int length = 0;
//	   String temp;
//	   while ((temp = reader.readLine()) != null && !temp.equals("1234567890das")) {
//		  length += temp.length() + 1;
//	   }
//	   access.skipBytes(length + 2);
//	   access.write("boyz".getBytes());
//
//    }
//}