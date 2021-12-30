public class test
{
  public static void main(String[] args)
  {
    PrintedBook pb1 = new PrintedBook("Game of Thrones", "123456789", true);
    PrintedBook pb2 = new PrintedBook("Storm of Swords", "987654321", true);
    PrintedBook pb3 = new PrintedBook("King of the North", "789456123", true);
    PrintedBook hc1 = new PrintedBook("Fellowship of the Ring", "22224444",
        false);
    PrintedBook hc2 = new PrintedBook("The Two Towers", "11113333", false);
    PrintedBook hc3 = new PrintedBook("Return of the King", "77779999", false);
    EBook eb1 = new EBook("getbooks.com/HP1", "Philosophers Stone", "88887777");
    EBook eb2 = new EBook("getbooks.com/HP2", "Chamber of Secrets", "99996666");
    EBook eb3 = new EBook("getbooks.com/HP3", "Prisoner of Azkaban",
        "44441111");

    BookList bookList = new BookList();
    bookList.addBook(eb1);
    bookList.addBook(eb2);
    bookList.addBook(eb3);
    bookList.addBook(pb1);
    bookList.addBook(pb2);
    bookList.addBook(pb3);
    bookList.addBook(hc1);
    bookList.addBook(hc2);
    bookList.addBook(hc3);

    System.out.println("Should be 9: " + bookList.getNumberOfBooks());
    System.out.println("Should be Philosophers Stone: " + bookList.getBook(0));
    System.out.println(
        "Should be Storm of Swords: " + bookList.getBook("987654321"));
    System.out.println("Should be 3: " + bookList.getIndexOfFirstPrintedBook());
    System.out.println(
        "Should be 3: " + bookList.getNumberOfBooksByType("Hard cover"));
    //System.out.println("Should throw exception: " + bookList.getNumberOfBooksByType("Good books"));
    System.out.println(bookList.getAllEBooks());
    System.out.println(bookList);

    BookList bl2 = new BookList();

    bl2.addBook(pb1);
    bl2.addBook(pb2);
    bl2.addBook(pb3);
    bl2.addBook(hc1);
    bl2.addBook(hc2);
    bl2.addBook(hc3);
    bl2.addBook(eb1);
    bl2.addBook(eb2);
    bl2.addBook(eb3);

    System.out.println(bookList.equals(bl2));

  }
}
