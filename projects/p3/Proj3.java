import java.util.Scanner;

public class Proj3 {

  public static void main(String[] args)
  {
    double subTotal;
    //TODO: make those constants
    int[] ticketPrices = {150, 272, 323, 455};
    int[] requiredDonations = {0, 200, 500, 1300};
    double[] discounts = {.5, .05, .1, .2, 0};

    Scanner s = new Scanner(System.in);

    System.out.println("Please Select from the following categories:");
    System.out.print("1)Student\n2)Alumni\n3)Faculty or Staff\n4)Military\n5)General Public\n");

    int demogSelection = Integer.parseInt(s.nextLine());

    while(demogSelection > 5 || demogSelection < 1)
    {
      System.out.println("invalid selection");
      demogSelection = Integer.parseInt(s.nextLine());
    }

    System.out.println("Please Select from the following seat locations:");
    System.out.print("1)View Level\n2)Premium View Level\n3)Premium Bench\n4)Club Level (No Students)\n");

    int locationSelection = Integer.parseInt(s.nextLine());
    //prevents large numbers from being entered and also prevents students from purchasing club level
    while((locationSelection > 4 || locationSelection < 1) || (locationSelection == 4 && demogSelection == 1))
    {
      System.out.println("invalid selection");
      locationSelection = Integer.parseInt(s.nextLine());
    }

    System.out.print("How many tickets would you like to purchase? ");
    int ticketCount = Integer.parseInt(s.nextLine());

    double ticketPrice = (ticketPrices[locationSelection - 1] * ticketCount);
    double discount = ticketPrice * discounts[demogSelection - 1];
    int processingFee = ticketCount * 2;
    double salesTax = (ticketPrice - (discount * ticketPrice)) * 0.066;

    System.out.print("Would you like to purchase parking for an additional $100 (Y or N)? ");
    char choice = s.nextLine().charAt(0);

    if(choice == 'y' || choice == 'Y')
    {
      subTotal += 100;
    }


  }

}
