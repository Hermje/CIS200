import java.util.*;

/*
 * Jake Herman (thursday lab 4:30-6:20)
 *
 *
 * Mortgage.java: structure for a mortgage object
 *                calculates monthly loan payment and total payment
 *
 */

public class Mortgage {
  private int accNum;
  private String lastName;

  private double interestRate;
  private int term;
  private double principal;

  public Mortgage(boolean customFlag)
  {
    Random r  = new Random();
    this.accNum = r.nextInt((10000 - 100) + 101); //generate a random account num
  }

  public Mortgage()
  {
    Random r  = new Random();
    this.accNum = r.nextInt((10000 - 100) + 101);
    this.interestRate = .03; //promo attributes
    this.term = 20;
    this.principal = 100000;
  }

  /** storeLoanAmount
   * prompts user for loan amount and validates it
   * @param s Scanner object passed in from mortgageApp
   */

  public void storeLoanAmount(Scanner s) {
    principal = Double.parseDouble(s.nextLine()); //turn principal (loan amount) into double
    while(principal < 75000 || principal > 1000000) //every time the user enters something out of bounds
    {
      System.out.println("please re enter loan amount. Must be between $75000 and $1000000."); //prompt user to enter principal in
      System.out.print("Loan amount: $");
      principal = Double.parseDouble(s.nextLine());
    }
  }

  /** storeTerm
   * prompts user for term (in years) and validates it
   * @param s Scanner object passed in from mortgageApp
   */

  public void storeTerm(Scanner s) {
    term = Integer.parseInt(s.nextLine());
    while(term < 10 || term > 40)
    {
      System.out.println("please re enter term. Must be between 10 and 40 years."); //prompt user to enter
      System.out.print("Term: ");
      term = Integer.parseInt(s.nextLine());
    }
  }

  /** storeInterestRate
   * prompts user for interest rate (as percent) and validates it
   * @param s Scanner object passed in from mortgageApp
   */

  public void storeInterestRate(Scanner s) {
    interestRate = Double.parseDouble(s.nextLine())/100;
    while(interestRate > .07 || interestRate < .02)
    {
      System.out.println("Please re enter interest rate. Must be between 2% and 7%.");
      System.out.print("Interest rate (as percent): ");
      interestRate = Double.parseDouble(s.nextLine())/100;
    }
  }

  /** storeLastName
   * prompts user for their last name
   * @param s Scanner object passed in from mortgageApp
   */

  public void storeLastName(Scanner s) {
    lastName = s.nextLine();
  }

  /** calcMonthlyPayment
   * calculates the monthly loan payment
   * @return the monthly loan payment
   */

  private double calcMonthlyPayment() {
    return principal * (interestRate * (Math.pow(1 + interestRate, term * 12)))/((Math.pow(1 + interestRate, term * 12))-1); //formula descriped in proj6.pdf
  }

  /** calcTotalPayment
   * calculates the monthly loan payment
   * @return the total loan payment
   */

  private double calcTotalPayment() {
    return calcMonthlyPayment() * (term*12);
  }

  /** toString
   * displays details of mortgage
   * @return all attributes of mortgage as a nice string
   */

  public String toString() {
    StringBuilder s = new StringBuilder();
    double monthlyPayment = calcMonthlyPayment();
    double totalPayment = calcTotalPayment();
    s.append(String.format("\nAccount Number: %s%d \n", lastName.substring(0,4), accNum));
    s.append(String.format("The monthly payment is: %.2f\n", monthlyPayment)); //round off to the nearest two decimals
    s.append(String.format("The total payment is: %.2f\n", totalPayment));

    return s.toString();
  }
}
