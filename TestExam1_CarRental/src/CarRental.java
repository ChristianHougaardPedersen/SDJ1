import java.util.ArrayList;

public class CarRental
{
  private String companyName, address;
  private ArrayList<Car> carsForRent;

  public CarRental(String companyName, String address)
  {
    this.companyName = companyName;
    this.address = address;
    this.carsForRent = new ArrayList<>();
  }

  public String getCompanyName()
  {
    return companyName;
  }

  public String getAddress()
  {
    return address;
  }

  public int getNumberOfCars()
  {
    return carsForRent.size();
  }

  public Car getCar(int index)
  {
    return carsForRent.get(index);
  }

  public void addCar(Car car)
  {
    carsForRent.add(car);
  }

  public Car getCarByLicense(String licenseNo)
  {
    for (Car i : carsForRent)
    {
      if (i.getLicenseNo().equals(licenseNo))
      {
        return i;
      }
    }

    throw new IllegalArgumentException(
        "No car with license number " + licenseNo + " found.");
  }

  public SportsCar getAvailableSportsCar()
  {
    for (Car i : carsForRent)
    {
      if (i.isAvailable() && i.getType().equals("SportsCar"))
      {
        return (SportsCar) i;
      }
    }

    throw new IllegalArgumentException("No available Sports Cars found.");
  }

  public Van getAvailableVan(int minCapacity)
  {
    for (Car i : carsForRent)
    {
      if (i.isAvailable() && i.getType().equals("Van") && ((Van) i).getCapacity() >= minCapacity)
      {
        return (Van) i;
      }
    }

    throw new IllegalArgumentException("No available van with minimum capacity of " + minCapacity + " found.");
  }

}
