public abstract class Residence
{
  private Tenant rentedTo;
  private int number;
  private double size;
  private String type;

  public Residence(int number, double size, String type)
  {
    this.number = number;
    this.size = size;
    this.rentedTo = null;

    if (type.equals("Room") || type.equals("Apartment"))
    {
      this.type = type;
    }
    else
      throw new IllegalArgumentException("Type should be Room or Apartment.");

  }

  public int getNumber()
  {
    return number;
  }

  public double getSize()
  {
    return size;
  }

  public String getType()
  {
    return type;
  }

  public boolean isAvailable()
  {
    return rentedTo == null;
  }

  public void rentTo(Tenant tenant, MyDate rentedFrom)
  {
    this.rentedTo = tenant;
    rentedTo.setRentedFrom(rentedFrom);
  }

  public Tenant getTenant()
  {
    return rentedTo;
  }

  public abstract int getNumberOfRooms();
}
