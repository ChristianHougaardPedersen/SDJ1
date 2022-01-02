
import java.util.Arrays;

public class Main
{
  public static void main(String[] args)
  {
    Resource r1 = new Resource("PowerPoint", "pptx");
    Resource r2 = new Resource("Excel spreadsheet", "xlsx");
    Resource r3 = new Resource("image", "img");
    Resource r4 = new Resource("Plan", "pdf");
    Resource r5 = new Resource("testExam", "PDF");

    Student s1 = new Student(1, "Student 1");
    Student s2 = new Student(2, "Student 2");
    Student s3 = new Student(3, "Student 3");
    Student s4 = new Student(4, "Student 4");

    Course c1 = new Course("SDJ1");
    Course c2 = new Course("SEP1");
    Course c3 = new Course("RWD1");
    Course c4 = new Course("DMA1");
    Course c5 = new Course("DummyCourse");

    Resource[] sdj1Res = new Resource[5];
    sdj1Res[0]=r1;
    sdj1Res[1]=r2;
    sdj1Res[2]=r3;
    sdj1Res[3]=r4;
    sdj1Res[4]=r5;


    // DMA1 (c4) is empty
    //System.out.println(c4.getAllLessons()); // throws exception - since arraylist is empty.
    System.out.println(c4.getName()); // should return name
    System.out.println(c4);
    //System.out.println(c4.getAllResources()); // throws exception - since arraylist is empty.
    // System.out.println(c4.getAllTopics()); // throws exception - since arraylist is empty.



    //      LESSON method-testing     \\

    Lesson lesson1 = new Lesson("Lesson1", new Date(1,1,2022), new Time(9,20,0), new Time(11,0,0), sdj1Res);
    System.out.println("|Should be Lesson1| - " + lesson1.getTopic());
    System.out.println("|Should be 01/01/2022| - " + lesson1.getDate());
    System.out.println("|Should be resources r1-r5| - " + Arrays.toString(lesson1.getResources()));
    System.out.println("|Should be resources r4+r5| - " + lesson1.getAllPDFs());
    System.out.println("|Should be 1 hours 40 minutes | - " + lesson1.getDuration());
    System.out.println("|Should be 01/01/2022 09:20:00 - 11:00:00| - " + lesson1.getDateTimeString());
    System.out.println(lesson1);


    //    COURSE - testing    \\

    c1.addLesson(
        new Lesson("SDJ Lesson 1", new Date(7, 1, 2022), new Time(8, 20, 0),
            new Time(9, 20, 0), sdj1Res));
    c1.addLesson(
        new Lesson("SDJ Lesson 2", new Date(7, 1, 2022), new Time(13, 20, 0),
            new Time(14, 20, 0), new Resource[0]));
    c1.addLesson(new DiscordLesson("Discord Lessons 101", new Date(12, 1, 2022),
        new Time(8, 20, 0), new Time(12, 0, 0), sdj1Res, false,
        "SDJ1 Channel"));
    c1.addLesson(new DiscordLesson("Discord Lessons With Camera 101",
        new Date(12, 1, 2022), new Time(12, 20, 0), new Time(15, 0, 0), sdj1Res,
        true, "SDJ1 Channel"));
    c1.addLesson(
        new ZoomLesson("Zoom 101", new Date(13, 1, 2022), new Time(9, 10, 0),
            new Time(11, 50, 0), sdj1Res, false, "via.dk/zoom_meeting_1",
            false));
    c1.addLesson(new ZoomLesson("Zoom with Camera 101", new Date(13, 1, 2022),
        new Time(19, 10, 0), new Time(21, 10, 0), sdj1Res, true,
        "via.dk/zoom_meeting_2", true));

    System.out.println("|Should be SDJ1| - " + c1.getName());
    System.out.println("|Should be 6| - " + c1.getNumberOfLessons());
    c1.removeLesson(new Lesson("SDJ Lesson 2", new Date(7,1,2022), new Time(13,20,0), new Time(14,20,0), new Resource[0]));
    System.out.println("|Should be 5| - " + c1.getNumberOfLessons());
    System.out.println("|Should be false| - " + c1.hasLessonOnDate(new Date(1,1,2022)));
    System.out.println("|Should be true| - " + c1.hasLessonOnDate(new Date(7,1,2022)));
    System.out.println("|Should print all above Topics| - " + c1.getAllTopics());
    System.out.println("|Should print the last 4 lessons above| - " + c1.getOnlineLessons());
    System.out.println("|Should print last and third from bottom lessons| - " + c1.getOnlineLessonsWithCameraRequired());
    System.out.println("|Should print the two discord lessons| - " + c1.getDiscordLessons());
    System.out.println("|Should print the last lesson| - " + c1.getZoomLessonsWithBreakoutRooms());
    System.out.println("|Should print each resource once!| - " + c1.getAllResources());
    System.out.println(c1);



    //    Student testing   \\

    System.out.println("|Should print 1| - " + s1.getStudentNumber());
    System.out.println("|Should print Student 1| - " + s1.getName());
    // System.out.println(s1.getAllCourses()); // throws exception - since student is not assigned to any courses
    s1.addCourse(c1);
    s1.addCourse(c2);
    s1.addCourse(c3);
    s1.addCourse(c4);
    System.out.println("|Should print all courses| - " + Arrays.toString(s1.getAllCourses()));

    //System.out.println(s1.getAllGrades()); // throws exception - because no grades are added
    s1.addGrade(12, c1);
    s1.addGrade(10, c2);
    s1.addGrade(7, c3);
    s1.addGrade(4, c4);
    //s1.addGrade(2,c5); // throws exception - student not assigned to course
    System.out.println(Arrays.toString(s1.getAllGrades()));
    System.out.println("|Should be 8,25| - " + s1.getGradeAverage());

    s1.addCoronaPassport(
        new CoronaPassport("Vaccinated", new Date(20, 12, 2021)));
    s2.addCoronaPassport(new CoronaPassport("Tested", new Date(1, 12, 2022)));
    s3.addCoronaPassport(new CoronaPassport("Infected", new Date(1,1,2021)));
    System.out.println(s1.getCoronaPassport());
    System.out.println(s2.getCoronaPassport());
    System.out.println(s3.getCoronaPassport());
    s4.addCoronaPassport(new CoronaPassport("Infected", new Date(12,12,2021)));

    System.out.println("|Should be true| - " + s1.hasValidCoronaPassport());
    System.out.println("|Should be false| - " + s2.hasValidCoronaPassport());
    System.out.println("|Should be false| - " + s3.hasValidCoronaPassport());
    System.out.println("|Should be true| - " + s4.hasValidCoronaPassport());
  }

}
