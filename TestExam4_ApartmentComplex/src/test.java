public class test
{
  public static void main(String[] args)
  {

    Room r1 = new Room(1,20);
    Room r2 = new Room(2,25);
    Room r3 = new Room(3,18);
    Apartment a1 = new Apartment(4, 40, 2);
    Apartment a2 = new Apartment(5,50,3);
    Apartment a3 = new Apartment(6,120,4);

    ApartmentComplex ac = new ApartmentComplex("Ryesgade 4F");
    ac.add(r1);
    ac.add(r2);
    ac.add(r3);
    ac.add(a1);
    ac.add(a2);
    ac.add(a3);

    System.out.println("Should be 6: " + ac.getNumberOfResidences());
    System.out.println("Should be room 1: " + ac.getResidence(0).getNumber());
    System.out.println("Should be no 4: " + ac.getResidenceByNumber(4).getNumber() );
    System.out.println("Should be room 1: " + ac.getFirstAvailableRoom().getNumber());
    System.out.println("Should be 5: " + ac.getFirstAvailableApartment(3).getNumber());

    ac.getResidenceByNumber(5).rentTo(new Tenant("Christian"), MyDate.now());
    ac.getResidenceByNumber(1).rentTo(new Tenant("Rikke"), MyDate.now());
    System.out.println("Should be 6: " + ac.getFirstAvailableApartment(3).getNumber());
    System.out.println("Should be room 2: " + ac.getFirstAvailableRoom().getNumber());
  }
}
