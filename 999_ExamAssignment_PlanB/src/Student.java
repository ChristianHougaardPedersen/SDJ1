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
    this.courses = new ArrayList<>();
    this.grades = new ArrayList<>();
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
    for (Course i : courses)
    {
      if (i.getName().equals(course.getName()))
      {
        grades.add(new Grade(grade, i));
        break;
      }
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
          && coronaPassport.getDate().numberOfDaysUntil(Date.today()) < 3
          || coronaPassport.getReason().equals("Infected")
          && coronaPassport.getDate().numberOfDaysUntil(Date.today()) > 14
          && coronaPassport.getDate().numberOfDaysUntil(Date.today()) < 180;
    }

    return false;
  }

  public double getGradeAverage()
  {
    double avg = 0;
    for (Grade i : grades)
    {
      avg+= i.getGrade();
    }
    avg /= grades.size();
    return avg;
  }

  public ArrayList<Grade> getAllGrades()
  {
    return grades;
  }

  public ArrayList<Course> getAllCourses()
  {
    return  courses;
  }

//TODO test
}
