import java.util.ArrayList;

public class StudentList
{
  private int size;
  private Student[] list;

  public StudentList(int size)
  {
    this.list = new Student[size];
  }

  public void addStudent(Student student)
  {
    for (int i = 0; i < list.length; i++)
    {
      if (list[i] == null)
      {
        list[i] = student;
        break;
      }
    }
  }

  public Student getStudent(int index)
  {
    return list[index];
  }

  public void removeStudent(Student student)
  {
    for (int i = 0; i < list.length; i++)
    {
      if (list[i].equals(student))
      {
        list[i]=null;
      }
    }
  }

  public int getNumberOfStudents()
  {
    int numberOfStudents = 0;
    for (Student i : list)
    {
      if (i != null)
      {
        numberOfStudents++;
      }
    }

    return numberOfStudents;
  }

  public int getNumberOfStudentByEducation(Education education)
  {
    int numberOfStudentsByEducation = 0;

    for (int i = 0; i < list.length; i++)
    {
      if (list[i].getEducation().equals(education))
      {
        numberOfStudentsByEducation++;
      }
    }
    return numberOfStudentsByEducation;
  }

  public Student[] getStudentsByEducation(Education education)
  {
    int numberOfStudentByEducation = getNumberOfStudentByEducation(education);
    Student[] studentsByEducation = new Student[numberOfStudentByEducation];
    int counter = 0;
    for (Student i : list)
    {
      if (i.getEducation().equals(education))
      {
        studentsByEducation[counter] = i;
        counter++;
      }
    }

    return studentsByEducation;
  }

  public int getNumberOfHighSchoolStudents()
  {
    int numberOfHighSchoolStudents = 0;
    for (Student i : list)
    {
      if (i.getEducation().equals(School.HIGH_SCHOOL))
      {
        numberOfHighSchoolStudents++;
      }
    }

    return numberOfHighSchoolStudents;
  }

  public void doubleTheListCapacity()
  {
    Student[] newList = new Student[size*2];
    for (int i = 0; i < list.length; i++)
    {
      newList[i] = list[i];
    }
  }

  //TODO FIX THIS!

}
