public class test
{
  public static void main(String[] args)
  {
    Topping cheese = new Topping("Chesse", 10);
    Topping tomato = new Topping("Tomato", 5);
    Topping pepperoni = new Topping("Pepperoni", 15);
    Topping sausage = new Topping("Sausage", 15);
    Topping kebab = new Topping("Kebab", 15);
    Topping ham = new Topping("Ham", 15);

    Pizza pizza1 = new Pizza("Plain", 40);
    Pizza pizza2 = new Pizza("Margarita", 40);
    pizza2.addTopping(tomato);
    pizza2.addTopping(cheese);

    Pizza pizza3 = new Pizza("Pepperoni", 40);
    pizza3.addTopping(tomato);
    pizza3.addTopping(cheese);
    pizza3.addTopping(pepperoni);

    Pizza pizza4 = new Pizza("Too much", 40);
    pizza4.addTopping(tomato);
    pizza4.addTopping(cheese);
    pizza4.addTopping(pepperoni);
    pizza4.addTopping(sausage);
    pizza4.addTopping(kebab);

    Customer c = new Customer("Rikke");
    PrivilegedCustomer pc = new PrivilegedCustomer("Christian");

    PizzaOrder order1 = new PizzaOrder(c);
    order1.addPizza(pizza1);
    order1.addPizza(pizza2);
    order1.addPizza(pizza3);
    order1.addPizza(pizza4);

    PizzaOrder order2 = new PizzaOrder(pc);
    order2.addPizza(pizza1);
    order2.addPizza(pizza2);
    order2.addPizza(pizza3);
    order2.addPizza(pizza4);

    System.out.println(order1.getNumberOfPizzas());
    System.out.println(order2.getNumberOfPizzas());
    pc.setDiscount(25);
    System.out.println(order1.getTotalPrice());
    System.out.println(order2.getTotalPrice());

  }
}
