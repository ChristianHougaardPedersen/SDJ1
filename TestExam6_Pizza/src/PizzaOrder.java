import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PizzaOrder
{
  private Customer customer;
  private ArrayList<Pizza> pizzas;

  public PizzaOrder(Customer customer)
  {
    this.customer = customer;
    this.pizzas = new ArrayList<>();
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public int getNumberOfPizzas()
  {
    return pizzas.size();
  }

  public void addPizza(Pizza pizza)
  {
    pizzas.add(pizza);
  }

  public Pizza getPizza(int index)
  {
    return pizzas.get(index);
  }

  public Pizza getPizza(String pizzaName)
  {
    for (Pizza i : pizzas)
    {
      if (i.getName().equals(pizzaName))
      {
        return i;
      }
    }

    throw new NoSuchElementException(
        "No pizza with name " + pizzaName + " found.");
  }

  public double getTotalPrice()
  {
    double totalPrice = 0;
    for (Pizza i : pizzas)
    {
      totalPrice += i.getTotalPrice();
    }

    if (customer instanceof PrivilegedCustomer)
    {
      return totalPrice - ((totalPrice * ((PrivilegedCustomer) customer).getDiscount())/100) ;
    }

    else
      return totalPrice;
  }
}
