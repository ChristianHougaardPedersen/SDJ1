import java.util.ArrayList;

public class House
{
  private ArrayList<Room> rooms = new ArrayList<>();

  public House(ArrayList<Room> rooms)
  {
    this.rooms = rooms;
  }

  public int getNumberOfRooms()
  {
    return rooms.size();
  }

  public double getTotalSize()
  {
    double totalSize = 0;
    for (Room i : rooms)
    {
      totalSize += i.getSize();
    }

    return totalSize;
  }

  public int getNumberOfBathrooms()
  {
    int bathRoomCounter = 0;
    for (Room i : rooms)
    {
      if (i instanceof BathRoom)
      {
        bathRoomCounter++;
      }
    }

    return bathRoomCounter;
  }

  public void rebuildRoom(int index, Room room)
  {
    rooms.remove(index);
    rooms.add(index, room);
  }

  public void combineTwoRoomsIntoOne(int index1, int index2, Room room)
  {
    rooms.remove(index2);
    rooms.remove(index1);
    rooms.add(index1, room);
  }

  public String toString()
  {
    String s = "House:\nSize: " + getTotalSize() + ", Number of rooms: " + getNumberOfRooms() + ", Number of bathrooms " + getNumberOfBathrooms();
    return s;
  }
}
