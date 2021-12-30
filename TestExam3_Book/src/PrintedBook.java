public class PrintedBook extends Book
{
  private boolean isPaperback;

  public PrintedBook(String title, String isbn, boolean paperback)
  {
    super(title, isbn);
    this.isPaperback = paperback;
  }

  public boolean isPaperback()
  {
    return isPaperback;
  }

  public String getBookType()
  {
    if (isPaperback())
    {
      return "Paperback";
    }
    else
      return "Hard cover";
  }

  public String toString()
  {
    return super.toString() + "\nType: " + getBookType();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof PrintedBook))
    {return false;}
    PrintedBook other = (PrintedBook) obj;
    return super.equals(obj) && isPaperback == other.isPaperback;
  }
}
