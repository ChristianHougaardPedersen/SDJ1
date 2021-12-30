import java.util.ArrayList;

public class Lesson
{
  private String topic;
  private Date date;
  private Time start, end;
  private ArrayList<Resource> res;

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

    if (!(hasValidTime(start, end)))
    {
      throw new IllegalArgumentException(
          "Lesson time not valid. Lesson is not allowed to start before 8:20,"
              + " end later than 21:10, "
              + "or have a start time that is after end time");
    }
    else
    {
      this.start = start.copy();
      this.end = end.copy();
    }

    this.res = res;

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

  public static boolean hasValidTime(Time startTime, Time endTime)
  {
    int earliestStartTimeInSeconds = 30000;
    int latestEndTimeInSeconds = 76200;


    if (startTime.convertToSeconds() >= earliestStartTimeInSeconds && endTime.convertToSeconds() <= latestEndTimeInSeconds)
    {
      return (!(endTime.isBefore(startTime)));
    }
    return false;
  }

  public String getDateTimeString()
  {
    return date + " " + start + " - " + end;
  }

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
    String s = "Topic: " + topic + ", Date and time: " + getDateTimeString();
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
}
