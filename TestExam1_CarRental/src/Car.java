public abstract class Car
{
  private String licenseNo;
  private double price;
  private Customer customer;

  public Car(String licenseNo, double price)
  {
    this.licenseNo = licenseNo;
    setPrice(price);
    this.customer = null;
  }

  public String getLicenseNo()
  {
    return licenseNo;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public abstract String getType();

  public Customer getRentedTo()
  {
    return customer;
  }

  public void setRentedTo(Customer customer)
  {
    this.customer = customer;
  }

  public boolean isAvailable()
  {
    return this.customer==null;
  }

}
