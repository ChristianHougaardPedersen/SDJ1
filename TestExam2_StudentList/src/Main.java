public class Main
{
  public static void main(String[] args)
  {
    Education edu1 = new Education("KND", "Kindergarden");
    Programme pro1 = new Programme("IT", "Software Engineering", "Bachelor");
    Programme pro2 = new Programme("IT", "Software Engineering", "Masters");
    School sch1 = new School("SCTIB", "Sct. Ibs Skole", "secondary");
    School sch2 = new School("HSGYM", "Horsens Statsskole", "high");

    System.out.println(pro1.equals(pro2));
    System.out.println(pro1);
    System.out.println(edu1);
    System.out.println(sch1);
/*
    Student stu1 = new Student("Christian Pedersen", edu1);
    Student stu2 = new Student("Christian Pedersen", pro2);
    System.out.println(stu1);
    stu1.changeEducation(sch2);
    System.out.println(stu1);
    stu1.changeEducation(pro1);
    System.out.println(stu1);

    System.out.println(stu1.equals(stu2));

 */

    Student stu1 = new Student("Student 1", edu1);
    Student stu2 = new Student("Student 2", edu1);
    Student stu3 = new Student("Student 3", edu1);
    Student stu4 = new Student("Student 4", edu1);
    Student stu5 = new Student("Student 5", pro1);
    Student stu6 = new Student("Student 6", pro1);
    Student stu7 = new Student("Student 7", pro1);
    Student stu8 = new Student("Student 8", pro1);
    Student stu9 = new Student("Student 9", sch1);
    Student stu10 = new Student("Student 10", sch1);
    Student stu11= new Student("Student 11", sch1);
    Student stu12= new Student("Student 12", sch1);
    Student stu13 = new Student("Student 13", sch2);
    Student stu14 = new Student("Student 14", sch2);
    Student stu15 = new Student("Student 15", sch2);
    Student stu16 = new Student("Student 16", sch2);

    StudentList sl = new StudentList(16);
    sl.addStudent(stu1);
    sl.addStudent(stu2);
    sl.addStudent(stu3);
    sl.addStudent(stu4);
    sl.addStudent(stu5);
    sl.addStudent(stu6);
    sl.addStudent(stu7);
    sl.addStudent(stu8);
    sl.addStudent(stu9);
    sl.addStudent(stu10);
    sl.addStudent(stu11);
    sl.addStudent(stu12);
    sl.addStudent(stu13);
    sl.addStudent(stu14);
    sl.addStudent(stu15);
    sl.addStudent(stu16);

    for (int i = 0; i < sl.getNumberOfStudents(); i++)
    {
      System.out.println(sl.getStudent(i));
    }

    System.out.println(sl.getStudent(15));
    sl.removeStudent(stu16);
    System.out.println(sl.getStudent(15));

    //System.out.println(sl.getNumberOfStudentByEducation(sch1));

    //System.out.println(sl.getStudentsByEducation(sch1));

    System.out.println(sl.getNumberOfHighSchoolStudents());



  }
}
