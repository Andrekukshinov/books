package by.kukshinov.books.model.specefication.search.factory;

import by.kukshinov.books.model.specefication.exception.NoSpecificationParamException;
import by.kukshinov.books.model.specefication.search.SearchBookSpecification;
import by.kukshinov.books.model.specefication.search.factory.emuns.SearchParam;
import by.kukshinov.books.model.specefication.search.impl.AuthorSearch;
import by.kukshinov.books.model.specefication.search.impl.PageSearcher;
import by.kukshinov.books.model.specefication.search.impl.PublisherSearch;
import by.kukshinov.books.model.specefication.search.impl.TitleSearch;

public class SearchSpecificationCreator {
    public SearchBookSpecification createSearchSpecification(SearchParam param) {
        switch(param) {
            case PAGE: return new PageSearcher();
            case AUTHOR: return new AuthorSearch();
            case TITLE: return new TitleSearch();
            case PUBLISHER: return new PublisherSearch();
            default: throw new NoSpecificationParamException("Searching by " + param + " is disabled");
        }
    }
}
