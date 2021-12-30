public class PrivilegedCustomer extends Customer
{
  private double discount;

  public PrivilegedCustomer(String name)
  {
    super(name);
    setDiscount(0);
  }


  public double getDiscount()
  {
    return discount;
  }

  public void setDiscount(double percentage)
  {
    this.discount = percentage;
  }
}
