package by.kukshinov.books.data.factory;


import by.kukshinov.books.data.acquirer.DataAcquirer;

public interface DataAcquirerCreator {
    DataAcquirer createDataAcquirer();
}
