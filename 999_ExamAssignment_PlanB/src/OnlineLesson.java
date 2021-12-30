import java.util.ArrayList;

public abstract class OnlineLesson extends Lesson
{
  private boolean cameraRequired;

  public OnlineLesson(String topic, Date date, Time start, Time end,
      ArrayList<Resource> res, boolean camera)
  {
    super(topic, date, start, end, res);
    this.cameraRequired = camera;
  }

  public boolean isCameraRequired()
  {
    return cameraRequired;
  }

  public abstract String nameOfSoftware();

  public boolean equals(Object obj)
  {
    if (!(obj instanceof OnlineLesson))
    {
      return false;
    }
    OnlineLesson other = (OnlineLesson) obj;
    return super.equals(obj) && cameraRequired == other.cameraRequired;
  }

  public String toString()
  {
    String s = super.toString();
    if (cameraRequired)
    {
      s += "\nCamera required.";
    }
    else
    {
      s += "\nCamera not required";
    }

    return s;
  }
}
