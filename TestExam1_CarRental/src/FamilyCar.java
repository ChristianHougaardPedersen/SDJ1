public class FamilyCar extends Car
{
  private int seats;

  public FamilyCar(String licenseNo, double price, int seats)
  {
    super(licenseNo, price);
    this.seats = seats;
  }

  public int getSeats()
  {
    return seats;
  }

  public String getType()
  {
    return "FamilyCar";
  }

}
