package by.kukshinov.books.model.specefication.sort.factory;


import by.kukshinov.books.model.specefication.exception.NoSpecificationParamException;
import by.kukshinov.books.model.specefication.sort.SortBookSpecification;
import by.kukshinov.books.model.specefication.sort.factory.emuns.SortParam;
import by.kukshinov.books.model.specefication.sort.impl.AuthorSort;
import by.kukshinov.books.model.specefication.sort.impl.PagesSort;
import by.kukshinov.books.model.specefication.sort.impl.PublisherSort;
import by.kukshinov.books.model.specefication.sort.impl.TitleSort;

public class SortSpecificationCreator {
    public SortBookSpecification createSortSpecification(SortParam param) {
        switch(param) {
            case PAGE: return new PagesSort();
            case AUTHOR: return new AuthorSort();
            case TITLE: return new TitleSort();
            case PUBLISHER: return new PublisherSort();
            default: throw new NoSpecificationParamException("Sorting " + param + " doesn't exsist");
        }
    }
}
