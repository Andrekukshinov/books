package by.kukshinov.books.model.data.access.impl;

//public class FileBookDAO implements BookDAO {
//    private final String filePath;
//
//    public FileBookDAO(String filePath) {
//	   this.filePath = filePath;
//    }
//
//    @Override
//    public void addBook(Book book) {
//
//    }
//
//    @Override
//    public List<Book> findBooks(SearchBookSpecification searchSpecification, String value) throws NoSuchBookException {
//	   return null;
//    }
//
//    @Override
//    public void remove(Book book) throws NoSuchBookException {
//	   try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
//			 RandomAccessFile access = new RandomAccessFile(filePath, "rw")) {
//		  String temp;
//		  int skipLength = getBookPointer(book, reader);
//		  access.skipBytes(skipLength);
//		  access.write("                                                                                                                                                ".getBytes());
//	   } catch (FileNotFoundException e) {
//		  e.printStackTrace();
//	   } catch (IOException e) {
//		  e.printStackTrace();
//	   }
//    }
//
//    private int getBookPointer(Book book, BufferedReader reader) throws IOException {
//	   String temp;
//	   int skipLength = 0;
//	   while ((temp = reader.readLine()) != null && !temp.equals(book.toString())) {
//		 skipLength += temp.length() + 1;
//	  }
//	   return skipLength;
//    }
//
//    @Override
//    public List<Book> sortArray(SortBookSpecification sortSpecification) {
//	   return null;
//    }
//}
