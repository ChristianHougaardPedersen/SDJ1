public class Van extends Car
{
  private int capacity;

  public Van(String licenceNo, double price, int capacity)
  {
    super(licenceNo, price);
    this.capacity = capacity;
  }

  public int getCapacity()
  {
    return  capacity;
  }

  public String getType()
  {
    return "Van";
  }


}
