import java.util.ArrayList;

public class Pizza
{
  private String name;
  private double initialPrice;
  private int numberOfToppings;
  private static final int MAX_NUMBER_OF_TOPPINGS = 5;
  private ArrayList<Topping> toppings;

  public Pizza(String name, double initialPrice)
  {
    this.name = name;
    this.initialPrice = initialPrice;
    this.toppings = new ArrayList<>();
  }

  public int getNumberOfToppings()
  {
    return toppings.size();
  }

  public void addTopping(Topping topping)
  {
    if (getNumberOfToppings() < MAX_NUMBER_OF_TOPPINGS)
    {
      toppings.add(topping);
    }
    else
      throw new IllegalStateException(
          "Maximum number of toppings cannot exceed 5");
  }

  public void removeTopping(String toppingName)
  {
    for (Topping i : toppings)
    {
      if (i.getName().equals(toppingName))
      {
        toppings.remove(i);
      }
    }
  }

  public double getTotalPrice()
  {
    double totalprice = initialPrice;
    for (Topping i : toppings)
    {
      totalprice += i.getPrice();
    }
    return totalprice;
  }


  //ADDED getName in order to use getPizzaByName method in PizzaOrder class...

  public String getName()
  {
    return name;
  }

}
