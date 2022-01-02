

public class ZoomLesson extends OnlineLesson
{
  private String link;
  private boolean breakoutRooms;

  public ZoomLesson(String topic, Date date, Time start, Time end,
      Resource[] res, boolean camera, String link, boolean breakout)
  {
    super(topic, date, start, end, res, camera);
    if (link.equals(""))
    {
      throw new IllegalArgumentException("Link should not be empty");
    }
    else {this.link = link;}
    this.breakoutRooms = breakout;
  }

  public String getLink()
  {
    return link;
  }

  public boolean usesBreakoutRooms()
  {
    return breakoutRooms;
  }

  public String nameOfSoftware()
  {
    return "Zoom";
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof ZoomLesson))
    {return false;}
    ZoomLesson other = (ZoomLesson) obj;
    return super.equals(obj) && link.equals(other.link) && breakoutRooms == other.breakoutRooms;
  }

  public String toString()
  {
    String s = "\nZoom Lesson:\n" + super.toString() + "\nLink: " + link;
    if (breakoutRooms)
    {
      s += "\nUses breakout rooms";
    }
    else {
      s+= "\nDoes not use breakout rooms";
    }

    return s;
  }
}
