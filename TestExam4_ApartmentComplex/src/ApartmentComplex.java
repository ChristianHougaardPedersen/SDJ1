import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ApartmentComplex
{
  private String address;
  private ArrayList<Residence> residences;

  public ApartmentComplex(String address)
  {
    this.address = address;
    this.residences = new ArrayList<>();
  }

  public int getNumberOfResidences()
  {
    return residences.size();
  }

  public void add(Residence residence)
  {
    residences.add(residence);
  }

  public Residence getResidence(int index)
  {
    return residences.get(index);
  }

  public Residence getResidenceByNumber(int number)
  {
    for (Residence i : residences)
    {
      if (i.getNumber() == number)
      {
        return i;
      }
    }

    throw new NoSuchElementException("No residence with number: " + number + " in complex.");
  }

  public Room getFirstAvailableRoom()
  {
    for (Residence i : residences)
    {
      if (i instanceof Room && i.isAvailable())
      {
        return (Room) i;
      }
    }

    throw new NoSuchElementException("No available rooms.");
  }

  public Apartment getFirstAvailableApartment(int minNoOfRooms)
  {
    for (Residence i : residences)
    {
      if (i instanceof Apartment && i.getNumberOfRooms()>= minNoOfRooms && i.isAvailable())
      {
        return (Apartment) i;
      }
    }
    throw new NoSuchElementException("No apartments with a minimum of " + minNoOfRooms + " rooms available.");
  }


}
