public class BathRoom extends RoomWithPlumbing
{
  private boolean hasShower;

  public BathRoom(double size, boolean hasShower)
  {
    super("Bathroom", size, true);
    this.hasShower = hasShower;
  }

  public boolean hasShower()
  {
    return hasShower;
  }

  public Room copy()
  {
    return new BathRoom(getSize(), hasShower());
  }

  public String toString()
  {
    return super.toString() + ", Shower: " + hasShower;
  }
}
