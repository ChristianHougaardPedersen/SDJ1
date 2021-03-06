import java.util.ArrayList;

public class Student
{
  private int studentNumber;
  private String name;
  private ArrayList<Course> courses;
  private ArrayList<Grade> grades;
  private CoronaPassport coronaPassport;

  public Student(int studentNumber, String name)
  {
    this.studentNumber = studentNumber;
    this.name = name;
    courses = new ArrayList<>();
    grades = new ArrayList<>();
    this.coronaPassport = null;
  }

  public int getStudentNumber()
  {
    return studentNumber;
  }

  public String getName()
  {
    return name;
  }

  public void addCourse(Course course)
  {
    courses.add(course);
  }

  public void addGrade(int grade, Course course)
  {
    if (courses.contains(course))
    {
      grades.add(new Grade(grade, course));
    }
    else
    {
      throw new IllegalArgumentException(
          "Student is not assigned to course: " + course.getName()
              + " Grade not added");
    }
  }

  public void addCoronaPassport(CoronaPassport passport)
  {
    this.coronaPassport = passport;
  }

  public void removeCoronaPassport()
  {
    this.coronaPassport = null;
  }

  public CoronaPassport getCoronaPassport()
  {
    return coronaPassport;
  }

  public boolean hasValidCoronaPassport()
  {
    if (coronaPassport.getDate().isBefore(Date.today()))
    {
      return coronaPassport.getReason().equals("Vaccinated")
          || coronaPassport.getReason().equals("Tested")
          && coronaPassport.getDate().numberOfDaysUntil(Date.today()) < 4
          || coronaPassport.getReason().equals("Infected")
          && coronaPassport.getDate().numberOfDaysUntil(Date.today()) > 14
          && coronaPassport.getDate().numberOfDaysUntil(Date.today()) < 181;
    }

    return false;
  }

  public double getGradeAverage()
  {
    double avg = 0;
    for (Grade i : grades)
    {
      avg += i.getGrade();
    }
    avg /= grades.size();
    return avg;
  }

  public Grade[] getAllGrades()
  {
    if (grades.isEmpty())
    {
      throw new IllegalStateException("Student has no current grades.");
    }
    Grade[] allGrades = new Grade[grades.size()];
    for (int i = 0; i < grades.size(); i++)
    {
      allGrades[i] = grades.get(i).copy();
    }

    return allGrades;

  }

  public Course[] getAllCourses()
  {
    if (courses.isEmpty())
    {
      throw new IllegalStateException(
          "Student not currently assigned any courses");
    }
    Course[] allCourses = new Course[courses.size()];
    for (int i = 0; i < courses.size(); i++)
    {
      allCourses[i] = courses.get(i);
    }

    return allCourses;
  }

}
