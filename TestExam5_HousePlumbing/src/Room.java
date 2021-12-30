public class Room
{
  private String name;
  private double size;

  public Room(String name, double size)
  {
    this.name = name;
    this.size = size;
  }

  public String getName()
  {
    return name;
  }

  public double getSize()
  {
    return size;
  }

  public Room copy()
  {
    return new Room(name, size);
  }

  public String toString()
  {
    return name + "size: " + size;
  }
}
