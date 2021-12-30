public class Topping
{
  private String name;
  private double price;

  public Topping(String name, double price)
  {
    this.name = name;
    setPrice(price);
  }

  public String getName()
  {
    return name;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }
}
