import java.util.Scanner;

/*
 * Proj3.java
 *
 * Jake Herman
 * 4:30 Lab Thu
 *
 * Season tickets purchasing program:
 *
 * Program to purchase season tickets for K state football. User enters
 * what demographic they fall into (students, military, etc) to calculate
 * discounts. Then their desired section, and how many seats they want in
 * that section. The user can also purchase a parking pass. Then a receipt
 * is output and they can purchase more tickets in a different section, if
 * necessary.
 *
 */

public class Proj3 {

  public static void main(String[] args)
  {
    //constants for various prices so this program can be easily modified every year
    final double VIEW_LEVEL_PRICE = 150;
    final double PREMIUM_VIEW_LEVEL_PRICE = 272;
    final double PREMIUM_BENCH_PRICE = 323;
    final double CLUB_LEVEL_PRICE = 455;

    final double VIEW_LEVEL_DONATION = 0;
    final double PREMIUM_VIEW_DONATION = 200;
    final double PREMIUM_BENCH_DONATION = 500;
    final double CLUB_LEVEL_DONATION = 1300;

    final double STUDENT_DISCOUNT = .5;
    final double ALUM_DISCOUNT = .05;
    final double STAFF_DISCOUNT = .1;
    final double MILITARY_DISCOUNT = .2;
    final double PUBLIC_DISCOUNT = 0;

    final double SALES_TAX = 0.066;
    //set to yes by default so the program starts
    char purchaseMore = 'y';

    while(purchaseMore == 'y' || purchaseMore == 'Y')
    {
      double subTotal = 0;
      double total = 0;
      //storing discounts and prices in arrays so if multiple if statements aren't necessary.
      //the user's selection number-1 can simply be used as the index to get a result;
      double[] ticketPrices = {VIEW_LEVEL_PRICE, PREMIUM_VIEW_LEVEL_PRICE, PREMIUM_BENCH_PRICE, CLUB_LEVEL_PRICE};
      double[] requiredDonations = {VIEW_LEVEL_DONATION, PREMIUM_VIEW_DONATION, PREMIUM_BENCH_DONATION, CLUB_LEVEL_DONATION};
      double[] discounts = {STUDENT_DISCOUNT, ALUM_DISCOUNT, STAFF_DISCOUNT, MILITARY_DISCOUNT, PUBLIC_DISCOUNT};

      String[] locations = {"View Level", "Premium View Level", "Premium Bench", "Club Level"};
      //scanner object, to get user input
      Scanner s = new Scanner(System.in);
      //prompt user to select what demographic they fall in, used for discounts. Also, students can't purchase club level.
      System.out.println("Please Select from the following categories:");
      System.out.print("1)Student\n2)Alumni\n3)Faculty or Staff\n4)Military\n5)General Public\n\nSelection: ");

      int demogSelection = Integer.parseInt(s.nextLine());
      //data validation
      while(demogSelection > 5 || demogSelection < 1)
      {
        System.out.println("invalid selection");
        demogSelection = Integer.parseInt(s.nextLine());
      }
      //prompt user to enter their desired selection
      System.out.println("Please Select from the following seat locations:");
      System.out.print("1)View Level\n2)Premium View Level\n3)Premium Bench\n4)Club Level (No Students)\n\nSelection: ");

      int locationSelection = Integer.parseInt(s.nextLine());
      //prevents large numbers from being entered (data validation) and also prevents students from purchasing club level
      while((locationSelection > 4 || locationSelection < 1) || (locationSelection == 4 && demogSelection == 1))
      {
        System.out.println("invalid selection");
        locationSelection = Integer.parseInt(s.nextLine());
      }
      //ask how many tickets they'd like to purchase
      System.out.print("How many tickets would you like to purchase? ");
      int ticketCount = Integer.parseInt(s.nextLine());
      //store every part of the calculation in different variables so outputting a receipt is easier
      double ticketPrice = (ticketPrices[locationSelection - 1] * ticketCount);
      double discount = ticketPrice * discounts[demogSelection - 1];
      double processingFee = 0;
      double donation = requiredDonations[locationSelection - 1];
      //students (1) and Military (4) don't have to pay the processing fee
      if(demogSelection != 1 && demogSelection != 4)
      {
        processingFee = 2 * ticketCount;
      }
      //calculate a sub total (for receipt)
      subTotal = (ticketPrice - discount) + processingFee;
      //calculate the sales tax on the sub total
      double salesTax = subTotal * SALES_TAX;
      //give the user the option to buy a parking pass
      System.out.print("Would you like to purchase parking for an additional $100 (Y or N)? ");
      //only take the first character of their entry (slight data validation) user could enter "yes" -> 'y'
      char choice = s.nextLine().charAt(0);

      if(choice == 'y' || choice == 'Y')
      {
        //parking passes are $100
        total += 100;
        System.out.printf("You ordered %d %s seats WITH parking\n", ticketCount, locations[locationSelection - 1]);
      } else {
        System.out.printf("You ordered %d %s seats WITHOUT parking\n");
      }
      //output receipt
      System.out.printf("Tickets: $%.2f\n", ticketPrice);
      System.out.printf("Discount: $%.2f\n", discount);
      System.out.printf("Processing fee: $%.2f\n", processingFee);
      System.out.printf("Subtotal: $%.2f\n", subTotal);
      System.out.printf("Sales Tax: $%.2f\n", salesTax);

      System.out.printf("Required donation: $%.2f\n", donation);
      //output parking price into receipt
      if(choice == 'y' || choice == 'Y')
      {
        System.out.println("Parking: $100");
      }
      //calculate final total
      total += (subTotal + salesTax + donation);
      //output final total
      System.out.printf("Total: $%.2f\n", total);
      //ask if they'd like to purchase more
      System.out.print("Would you like to purchase more tickets? ('Y' or 'N') ");
      purchaseMore = s.nextLine().charAt(0);
    }
  }

}
