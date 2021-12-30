public class Main
{
  public static void main(String[] args)
  {
    CarRental rental = new CarRental("Rental Company", "Rental Street 123");
    rental.addCar(new FamilyCar("TT24071", 750, 5));
    rental.addCar(new Van("RE34512", 700, 1500));
    rental.addCar(new Van("RE54512", 750, 2000));
    rental.addCar(new SportsCar("XX99999", 1500));
    rental.addCar(new SportsCar("XX99997", 2000));

    System.out.println(rental.getAvailableSportsCar().getLicenseNo());
    System.out.println(rental.getAvailableVan(1700).getLicenseNo());
    System.out.println(rental.getAvailableVan(1500).getLicenseNo());
    rental.getAvailableSportsCar().setRentedTo(new Customer("Bob Builder", "Builder Avenue 12"));
    System.out.println(rental.getAvailableSportsCar().getLicenseNo());
    rental.getAvailableSportsCar().setRentedTo(new Customer("Wendy Worker", "Worker Boulevard 78"));
    System.out.println(rental.getAvailableSportsCar());



  }
}
