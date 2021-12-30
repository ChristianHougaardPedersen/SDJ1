import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BookList
{
  private ArrayList<Book> bookList;

  public BookList()
  {
    this.bookList = new ArrayList<>();
  }

  public int getNumberOfBooks()
  {
    return bookList.size();
  }

  public void addBook(Book book)
  {
    bookList.add(book);
  }

  public Book getBook(int index)
  {
    return bookList.get(index);
  }

  public Book getBook(String isbn)
  {
    for (Book i : bookList)
    {
      if (i.getIsbn().equals(isbn))
      {
        return i;
      }
    }

    throw new IllegalArgumentException(
        "No book with ISBN: " + isbn + " found.");
  }

  public void removeBook(int index)
  {
    bookList.remove(index);
  }

  public int getIndexOfFirstPrintedBook()
  {
    for (int i = 0; i < bookList.size(); i++)
    {
      if (getBook(i) instanceof PrintedBook)
      {
        return i;
      }
    }

    throw new NoSuchElementException("No printed books in current book list");
  }

  public int getNumberOfBooksByType(String bookType)
  {
    int counter = 0;
    switch (bookType)
    {
      case "Paperback":
      case "Hard cover":
      case "E-book":
        for (Book i : bookList)
        {
          if (i.getBookType().equals(bookType))
          {
            counter++;
          }
        }
        break;
      default:
        throw new IllegalArgumentException(
            "Book Type should be: Paperback, Hard cover or E-book.");
    }

    return counter;
  }

  public ArrayList<Book> getBooksByType(String bookType)
  {
    ArrayList<Book> booksByType = new ArrayList<>();
    switch (bookType)
    {
      case "Paperback":
      case "Hard cover":
      case "E-book":
        for (Book i : bookList)
        {
          if (i.getBookType().equals(bookType))
          {
            booksByType.add(i);
          }
        }
        break;
      default:
        throw new IllegalArgumentException(
            "Book Type should be: Paperback, Hard cover or E-book.");
    }

    return booksByType;
  }

  public ArrayList<EBook> getAllEBooks()
  {
    ArrayList<EBook> allEBooks = new ArrayList<>();
    for (Book i : bookList)
    {
      if (i instanceof EBook)
      {
        allEBooks.add((EBook) i);
      }
    }

    return allEBooks;
  }

  public String toString()
  {
    String s = "";
    for (Book i : bookList)
    {
      s += "\nBOOK: " + i;
    }

    return s;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof BookList))
    {
      return false;
    }
    BookList other = (BookList) obj;
    if (!(getNumberOfBooks() == other.getNumberOfBooks()))
    {
      return false;
    }
    for (int i = 0; i < bookList.size(); i++)
      if (!(getBook(i).equals(other.getBook(i))))
      {
        return false;
      }

    return true;
  }
}
