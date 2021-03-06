package by.kukshinov.books.data.factory;


import by.kukshinov.books.data.BookField;
import by.kukshinov.books.data.specefication.SortBookSpecification;
import by.kukshinov.books.data.specefication.impl.sort.AuthorSortSpecification;
import by.kukshinov.books.data.specefication.impl.sort.PagesSortSpecification;
import by.kukshinov.books.data.specefication.impl.sort.PublisherSortSpecification;
import by.kukshinov.books.data.specefication.impl.sort.TitleSortSpecification;

public class SortSpecificationCreator {

    public SortBookSpecification createSortSpecification(BookField param) {
	   switch (param) {
		  case PAGE:
			 return new PagesSortSpecification();
		  case AUTHOR:
			 return new AuthorSortSpecification();
		  case TITLE:
			 return new TitleSortSpecification();
		  case PUBLISHER:
			 return new PublisherSortSpecification();
		  default:
			 throw new IllegalArgumentException(
				    String.format("Sorting by %s doesn't exist", param));
	   }
    }
}
