import java.util.ArrayList;

public class Lesson
{
  private String topic;
  private Date date;
  private Time start, end;
  //private Resource[] res; - USING ARRAYLIST INSTEAD
  private ArrayList<Resource> res;

  //    Can we use arraylist for res, since no fixed size is given??
  public Lesson(String topic, Date date, Time start, Time end, ArrayList<Resource> res)
  {
    if (topic.equals(""))
    {
      throw new IllegalArgumentException("Lesson must have a topic");
    }
    else
    {
      this.topic = topic;
    }

    this.date = date.copy();

    if (hasValidTime(start, end))
    {
      this.start = start.copy();
      this.end = end.copy();
    }
    else
    {
      throw new IllegalArgumentException(
          "Lesson time not valid. Lesson is not allowed to start before 8:20,"
              + " end later than 21:10, "
              + "or have a start time that is after end time");
    }

    this.res = new ArrayList<>();

  }

  public String getTopic()
  {
    return topic;
  }

  public Date getDate()
  {
    return date.copy();
  }

  public ArrayList<Resource> getResources()
  {
    return res;
  }

  public ArrayList<Resource> getAllPDFs()
  {
    ArrayList<Resource> allPDFs = new ArrayList<>();
    for (Resource i : res)
    {
      if (i.isPDF())
      {
        allPDFs.add(i);
      }
    }
    return allPDFs;
  }

  public Time getDuration()
  {
    return new Time((start.timeUntil(end)).convertToSeconds());
  }

  // NEEDS TESTING + REPHRASING
  public static boolean hasValidTime(Time startTime, Time endTime)
  {
    Time earliestStartTime = new Time(8, 20, 0);
    Time latestEndTime = new Time(21, 10, 0);
    if (startTime.equals(earliestStartTime) || !(startTime.isBefore(
        earliestStartTime)))
    {
      if (endTime.equals(latestEndTime) || endTime.isBefore(latestEndTime))
      {
        if (endTime.isBefore(startTime))
        {
          return true;
        }
      }
    }
    return false;
  }

  public String getDateTimeString()
  {
    return date + " " + start + " - " + end;
  }

  //    CHECK RES-COMPARE
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Lesson))
    {
      return false;
    }
    Lesson other = (Lesson) obj;
    return topic.equals(other.topic) && start.equals(other.start) && end.equals(
        other.end) && res.equals(other.res);
  }

  public String toString()
  {
    String s = "Topic: " + ", Date and time: " + getDateTimeString();
    if (getResources().size() > 0)
    {
      s += "\nResources:";
      for (Resource i : res)
      {
        s += "\n" + i;
      }
    }
    return s;
  }

  //TODO Test this class
}
