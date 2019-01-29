import Java.util.Scanner;

public class Jan29 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    /*
     * not only does Scanner.nextDouble() eliminate the need for Double.parseDouble
     * but unlike Scanner.nextLine, the newline character is not included. Same with
     * Scanner.nextInt().
    */
    Double balance = s.nextDouble();
    int age = s.nextInt();

    // read in a single character:
    System.out.println("Enter in Y)es or N)o:");
    /* doesn't exclusively accept a single character, just takes the first
       character of what is enter. If "yes" was entered, ch = "y" */
    char ch = s.charAt(0);

    // Java escape sequences (doesn't interfere with the quotes for the string):
    System.out.println("Your friend says \"hi\" ");

    // implicit cast:
    int year = 2019;
    double yearDouble = year; /* valid by primitive data type ranking, the integer is
                               * implicitly casted into a Double
                               */

    // operator precedence:
    double result = 1/4 * 100; // this evaluates to zero because 1/4 is integer division and is therefore truncated to 0
  }

}
