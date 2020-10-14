package by.kukshinov.books.data.factory;


import by.kukshinov.books.data.BookField;
import by.kukshinov.books.data.specefication.SearchSpecification;
import by.kukshinov.books.data.specefication.impl.search.AuthorSearchSpecification;
import by.kukshinov.books.data.specefication.impl.search.PageSearcherSpecification;
import by.kukshinov.books.data.specefication.impl.search.PublisherSearchSpecification;
import by.kukshinov.books.data.specefication.impl.search.TitleSearchSpecification;

public class SearchSpecificationCreator {
    public SearchSpecification createSearchSpecification(BookField param) {
        switch(param) {
            case PAGE:
                return new PageSearcherSpecification();
            case AUTHOR:
                return new AuthorSearchSpecification();
            case TITLE:
                return new TitleSearchSpecification();
            case PUBLISHER:
                return new PublisherSearchSpecification();
            default:
                throw new IllegalArgumentException(String.format("Searching by %s is disabled", param));
        }
    }
}
