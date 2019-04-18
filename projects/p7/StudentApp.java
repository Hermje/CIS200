import java.util.*;

/*
 *
 * Jake Herman Thu Lab (4:30-6:20)
 * StudentApp: utilizes View and Student to allow user to manage CIS200 students
 *
 */

public class StudentApp {

  public static void main(String[] args)
  {
    View view = new View(); //create new view object
    ArrayList<Student> students = new ArrayList<Student>(); //using arraylist for add method
    char keepGoing = 'y';

    double maxLabPoints = view.getLabMax(); //use methods in View to prompt for values
    double maxProjectPoints = view.getProjMax();
    double maxExamPoints = view.getExamMax();
    double maxZyPoints = view.getZyMax();
    double maxFinalPoints = view.getFinalMax();

    int studentCount = 0; //keeps track of how many students were entered

    while(keepGoing == 'y' || keepGoing == 'Y') //user is asked if they'd like to enter more students
    {
      //student object storing max values, used in calcOverallPercent
      Student max = new Student("max", "possible", "00000001", maxLabPoints, maxProjectPoints, maxExamPoints, maxZyPoints, maxFinalPoints);

      String userFirstName = view.getFirstName(); //promp user for student info using View methods
      String userLastName = view.getLastName();
      String wid = view.getWID();

      double userLabPoints = view.getLabTotal();
      double userProjectPoints = view.getProjTotal();
      double userExamPoints = view.getExamTotal();
      double userZyPoints = view.getZyTotal();
      double userFinalPoints = view.getFinalScore();

      Student student = new Student(userFirstName, userLastName, wid, userLabPoints, userProjectPoints, userExamPoints, userZyPoints, userFinalPoints);

      student.calcOverallPercent(max); //voided method, just updates value for the student object this method is called on

      students.add(student); //store student data in array list
      studentCount++; //increment student count

      view.displayStudentCount(studentCount); //let the user know have many students have been entered, and see if they'd like to continue.
      keepGoing = view.checkContinue();
    }

    view.displayStudents(students); //displays each new student object, seperated by pressing enter
  }
}
