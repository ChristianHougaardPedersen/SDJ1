import java.util.ArrayList;

public class Course
{
  private String name;
  private ArrayList<Lesson> schedule;

  public Course(String name)
  {
    if (name.equals(""))
    {
      throw new IllegalArgumentException("Course name should not be empty");
    }
    this.name = name;
    this.schedule = new ArrayList<>();
  }

  public String getName()
  {
    return name;
  }

  public int getNumberOfLessons()
  {
    return schedule.size();
  }

  public void addLesson(Lesson lesson)
  {
    schedule.add(lesson);
  }

  public void removeLesson(Lesson lesson)
  {
    schedule.remove(lesson);
  }

  public boolean hasLessonOnDate(Date date)
  {
    for (Lesson i : schedule)
    {
      if (i.getDate().equals(date))
      {
        return true;
      }
    }
    return false;
  }

  public ArrayList<Lesson> getAllLessons()
  {
    if (getNumberOfLessons() == 0)
    {
      throw new IllegalStateException("No lessons added for current course");
    }
    return schedule;
  }

  public ArrayList<String> getAllTopics()
  {
    ArrayList<String> allTopicsList = new ArrayList<>();
    for (Lesson i : schedule)
    {
      allTopicsList.add(i.getTopic());
    }

    if (allTopicsList.isEmpty())
    {
      throw new IllegalStateException("No topics added for current course");
    }
    return allTopicsList;
  }

  public ArrayList<OnlineLesson> getOnlineLessons()
  {
    ArrayList<OnlineLesson> onlineLessons = new ArrayList<>();
    for (Lesson i : schedule)
    {
      if (i instanceof OnlineLesson)
      {
        onlineLessons.add((OnlineLesson) i);
      }
    }

    return onlineLessons;
  }

  public ArrayList<OnlineLesson> getOnlineLessonsWithCameraRequired()
  {
    ArrayList<OnlineLesson> onlineLessonsWithCameraRequired = new ArrayList<>();
    for (OnlineLesson i : getOnlineLessons())
    {
      if (i.isCameraRequired())
      {
        onlineLessonsWithCameraRequired.add(i);
      }
    }

    return onlineLessonsWithCameraRequired;
  }

  public ArrayList<DiscordLesson> getDiscordLessons()
  {
    ArrayList<DiscordLesson> discordLessons = new ArrayList<>();
    for (OnlineLesson i : getOnlineLessons())
    {
      if (i.nameOfSoftware().equals("Discord"))
      {
        discordLessons.add((DiscordLesson) i);
      }
    }

    return discordLessons;
  }

  public ArrayList<ZoomLesson> getZoomLessonsWithBreakoutRooms()
  {
    ArrayList<ZoomLesson> zoomLessonsWithBreakoutRooms = new ArrayList<>();
    for (OnlineLesson i : getOnlineLessons())
    {
      if (i.nameOfSoftware().equals("Zoom") && i.isCameraRequired())
      {
        zoomLessonsWithBreakoutRooms.add((ZoomLesson) i);
      }
    }

    return zoomLessonsWithBreakoutRooms;
  }

  public ArrayList<Resource> getAllResources()
  {
    ArrayList<Resource> allResourcesForCourse = new ArrayList<>();
    for (Lesson i : schedule)
    {
      for (Resource j : i.getResources())
      {
        if (!(allResourcesForCourse.contains(j)))
        {
          allResourcesForCourse.add(j);
        }
      }
    }
    if (allResourcesForCourse.isEmpty())
    {
      throw new IllegalStateException("No resources added for current course");
    }
    return allResourcesForCourse;
  }

  public String toString()
  {
    return "\nCourse Name: " + name + ", Number of lessons: "
        + getNumberOfLessons() + "\nNumber of physical lessons: " + (
        getNumberOfLessons() - getOnlineLessons().size())
        + "\nNumber of Zoom-lessons: " + (getOnlineLessons().size()
        - getDiscordLessons().size()) + "\nNumber of Discord-lessons: "
        + getDiscordLessons().size();
  }
}
