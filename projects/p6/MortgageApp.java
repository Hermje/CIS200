import java.util.*;

/*
 * Jake Herman (thursday lab 4:30-6:20)
 *
 *
 * MortgageApp.java: Handles user input and menu for entering mortgages
 *
 */

public class MortgageApp {
  public static void main(String[] args)
  {
    ArrayList<Mortgage> mortgages = new ArrayList<Mortgage>(); //store in array list because the add method is nice
    Scanner s = new Scanner(System.in); //passed into mortgage class methods, used to fill private attributs
    Scanner userIn = new Scanner(System.in); //used to operate menu
    int selection = 0; //stores user menu selection
    int mCount = 0; //counts how many mortgages have been entered

    while(selection != 3 && mCount < 10)
    {
      //prompt user with menu
      System.out.println("Please choose from the following choices:");
      System.out.println("\t 1) Promotional Loan (preset loan amount, rate, term)");
      System.out.println("\t 2) Unique Loan (enter values)");
      System.out.println("\t 3) quit");
      System.out.println("\n\tEnter your selection:");

      selection = Integer.parseInt(userIn.nextLine()); //get selection from the user
      //check user input then choose how to handle mortgage input
      if(selection == 1){
        //preset
        Mortgage mortgage = new Mortgage();
        System.out.println("enter customer's last name: ");
        mortgage.storeLastName(s);

        System.out.println("\nPROMOTIONAL LOAN:");
        System.out.println(mortgage);

        mortgages.add(mortgage);
      } else if(selection == 2){
        //custom, prompt for all attributes
        Mortgage mortgage = new Mortgage(true);
        System.out.println("enter customer's last name: ");
        mortgage.storeLastName(s);
        System.out.println("enter loan amount ($75000 - $1000000): $");
        mortgage.storeLoanAmount(s);
        System.out.println("enter a yearly interest rate: ");
        mortgage.storeInterestRate(s);
        System.out.println("enter number of years for the loan: ");
        mortgage.storeTerm(s);

        System.out.println("\nUNIQUE LOAN:");
        System.out.println(mortgage); //implicitly calls the toString method

        mortgages.add(mortgage); //add to the mortgages array list
      }

      mCount++;
    }
    //user quit or 10 mortgages were entered
    Mortgage[] mortgagesButAsAnArrayHeHe = mortgages.toArray(new Mortgage[mortgages.size()]); //convert array list to array for whatever reason

    for(Mortgage mortgage: mortgagesButAsAnArrayHeHe) //iterate over the array and display results
    {
      System.out.println(mortgage);
    }

  }

}
