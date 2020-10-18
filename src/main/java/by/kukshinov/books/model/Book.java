package by.kukshinov.books.model;

import java.util.Objects;

public class Book {
    private final String author;
    private final int pages;
    private final String title;
    private final String publisher;
    private final BookType type;

    public Book(
		  String author, int pages, String title, String publisher, BookType type) {
	   this.author = author;
	   this.pages = pages;
	   this.title = title;
	   this.publisher = publisher;
	   this.type = type;
    }

    public String getAuthor() {
	   return author;
    }

    public int getPages() {
	   return pages;
    }

    public String getTitle() {
	   return title;
    }

    public String getPublisher() {
	   return publisher;
    }

    public BookType getType() {
	   return type;
    }

    @Override
    public String toString() {
	   String format = String
			 .format("Book{author=%s, pages=%d, title=%s, publisher=%s, type=}%s",
				    author, pages, title, publisher, type.toString());
	   return format;
    }

    @Override
    public boolean equals(Object o) {
	   if (this == o) {
		  return true;
	   }
	   if (o == null || getClass() != o.getClass()) {
		  return false;
	   }
	   Book book = (Book) o;
	   return getPages() == book.getPages() && Objects
			 .equals(getAuthor(), book.getAuthor()) && Objects
			 .equals(getTitle(), book.getTitle()) && Objects
			 .equals(getPublisher(), book.getPublisher()) && getType() == book
			 .getType();
    }

    @Override
    public int hashCode() {
	   return Objects
			 .hash(getAuthor(), getPages(), getTitle(), getPublisher(), getType());
    }
}
