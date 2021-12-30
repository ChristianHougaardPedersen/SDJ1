import java.util.ArrayList;

public class test
{
  public static void main(String[] args)
  {
    ArrayList<Room> rooms = new ArrayList<>();
    Room kitchen = new RoomWithPlumbing("Kitchen", 30, false);
    Room dining = new Room("Dining Room", 30);
    Room guestBathRoom = new BathRoom(10, false);
    Room bedroom = new Room("Bedroom", 20);
    Room masterBath = new BathRoom(20, true);
    Room livingRoom = new Room("Living Room", 30);
    rooms.add(kitchen);
    rooms.add(dining);
    rooms.add(guestBathRoom);
    rooms.add(bedroom);
    rooms.add(masterBath);
    rooms.add(livingRoom);

    House house = new House(rooms);

    System.out.println("Should be 6: " + house.getNumberOfRooms());
    System.out.println("Should be 2: " + house.getNumberOfBathrooms());
    System.out.println(rooms.get(2));
    System.out.println(house);

    house.rebuildRoom(2, new BathRoom(10, true));
    System.out.println(rooms.get(2));
    System.out.println(house);

    house.combineTwoRoomsIntoOne(0,1, new RoomWithPlumbing("Kitchen/Dining room", 60, false));
    System.out.println(rooms.get(0));
    System.out.println(house.getNumberOfBathrooms());
    System.out.println(house);
  }
}
