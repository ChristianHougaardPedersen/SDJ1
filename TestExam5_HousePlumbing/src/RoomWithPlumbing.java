public class RoomWithPlumbing extends Room
{
  private boolean floorDrain;

  public RoomWithPlumbing(String name, double size, boolean hasFloorDrain)
  {
    super(name, size);
    this.floorDrain = hasFloorDrain;
  }

  public boolean hasFloorDrain()
  {
    return floorDrain;
  }

  public Room copy()
  {
    return new RoomWithPlumbing(getName(), getSize(), hasFloorDrain());
  }

  public String toString()
  {
    return super.toString() + ", with plumbing. Has floor drain: " + hasFloorDrain();
  }
}
