import java.util.*;

public class View {

  /** getFirstName
   * Prompts user to enter the first name of the student they are grading
   * @return a string that is the first name of a student
   */

  public String getFirstName()
  {
    Scanner s = new Scanner(System.in); //create scanner object
    System.out.print("Enter first name: "); //prompt user for input
    return s.nextLine(); //return line as string
  }

  /** getLastName
   * Prompts user to enter the last name of the student they are grading
   * @return a string that is the last name of a student
   */

  public String getLastName()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter last name: ");
    return s.nextLine();
  }

  /** getWID
   * Prompts user to enter the WID of the student they are grading
   * @return a string that is the WID of a student
   */

  public String getWID()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter WID: ");
    return s.nextLine();
  }

  /** getLabTotal
   * Prompts user to enter the lab score of the student they are grading
   * @return a double that is the total lab points a student earned
   */

  public double getLabTotal()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Total Lab Points: ");
    return Double.parseDouble(s.nextLine()); //convert string to double, expecting an double. no data validation required...
  }

  /** getProjTotal
   * Prompts user to enter the project score of the student they are grading
   * @return a double that is the total project score a student earned
   */

  public double getProjTotal()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Total Project Points: ");
    return Double.parseDouble(s.nextLine());
  }

  /** getExamTotal
   * Prompts user to enter the exam score of the student they are grading
   * @return a double that is the total exam points a student earned
   */

  public double getExamTotal()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Total Exam Points: ");
    return Double.parseDouble(s.nextLine());
  }

  /** getZyTotal
   * Prompts user to enter the zybooks score of the student they are grading
   * @return a double that is the total zybooks points a student earned
   */

  public double getZyTotal()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Total ZyBooks Points: ");
    return Double.parseDouble(s.nextLine());
  }

  /** getFinalTotal
   * Prompts user to enter the final score of the student they are grading
   * @return a double that is the final score a student earned
   */

  public double getFinalScore()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter your score from the final: ");
    return Double.parseDouble(s.nextLine());
  }

  /** getLabMax
   * Prompts user to enter the maximum points a student can earn from labs
   * @return a double that is the maximum points possible to earn from labs
   */

  public double getLabMax()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter max. possible Lab Points: ");
    return Double.parseDouble(s.nextLine());
  }

  /** getLabMax
   * Prompts user to enter the maximum points a student can earn from projects
   * @return a double that is the maximum points possible to earn from projects
   */

  public double getProjMax()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter max. possible Project Points: ");
    return Double.parseDouble(s.nextLine());
  }

  /** getExamMax
   * Prompts user to enter the maximum points a student can earn from exams
   * @return a double that is the maximum points possible to earn from exams
   */

  public double getExamMax()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter max. possible Exam Points: ");
    return Double.parseDouble(s.nextLine());
  }

  /** getZyMax
   * Prompts user to enter the maximum points a student can earn from Zybooks assignments
   * @return a double that is the maximum points possible to earn from Zybooks assignments
   */

  public double getZyMax()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter max. possible ZyBooks Points: ");
    return Double.parseDouble(s.nextLine());
  }

  /** getFinsMax
   * Prompts user to enter the maximum points a student can earn on the final
   * @return a double that is the maximum points possible to earn from the final
   */

  public double getFinalMax()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the max. possible final score: ");
    return Double.parseDouble(s.nextLine());
  }

  /** checkContinue
   * asks the user if they'd like to continue grading students
   * @return a char (y/n)
   */

  public char checkContinue()
  {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter another student? (Y/N): ");
    return s.nextLine().charAt(0);
  }

  /** displayStudentCount
   * displays the amount of students the user has currently entered
   * @return an integer that is the amount of students that have been added to the system.
   */

  public void displayStudentCount(int count)
  {
    System.out.println(String.format("%d student(s) entered", count));
  }

  /** displayStudents
   * iterates over the ArrayList of student objects passed in, calling the toString method on each, summarizing what was entered by the user.
   * @param students an ArrayList containing student objects
   */

  public void displayStudents(ArrayList<Student> students)
  {
    Scanner s = new Scanner(System.in);

    for(Student student : students) //for each
    {
      System.out.println(student); //toString is implicitly called
      System.out.println("Press enter to continue...");
      s.nextLine(); //only continues if enter is pressed
    }

    System.out.println("all students displayed..."); //finished
  }
}
