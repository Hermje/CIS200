/**
* Proj1.java
* Jake Herman / Fri 3:30
*
* Class grade calculator: takes in the scores ofthree projects a midterm and the final
* then outputs the overall class grade.
*
* Pizza party calculator: takes in the number of people at a party and figure out
* how many x-large pizzas (20 slices) need to be ordered for the atendees (at 2 slices each).
*/

import java.util.Scanner;

public class Proj1 {

  public static void main(String[] args) {
    //scanner object and input string will be reused in the two programs
    Scanner s = new Scanner(System.in);
    String input;

    //constant of total points possible in the class
    final double totalPoints = 290;
    double runningTotal = 0;
    //prompt user to score of project 1
    System.out.print("Enter score (out of 30 pts) for project 1:");
    //store string input in input
    input = s.nextLine();
    //convert input into a double and increment the running total
    runningTotal += Double.parseDouble(input);
    //repeating previous steps to collect all data
    System.out.print("Enter score (out of 30 pts) for project 2:");
    input = s.nextLine();

    runningTotal += Double.parseDouble(input);

    System.out.print("Enter score (out of 30 pts) for project 3:");
    input = s.nextLine();

    runningTotal += Double.parseDouble(input);

    System.out.print("Enter the midterm exam score (0-100):");
    input = s.nextLine();

    runningTotal += Double.parseDouble(input);

    System.out.print("Enter the final exam score (0-100):");
    input = s.nextLine();

    runningTotal += Double.parseDouble(input);
    //display class results and calculate overall grade
    System.out.printf("Overall grade percentage: %.2f", (runningTotal/totalPoints) * 100);
    //put a percent sign in the output
    System.out.print("%\n");

    //pizza program (reusing input, and scanner objects):
    final int totalSlices = 20;
    final int slicesPerPerson = 2;
    //obtain amount of atendees
    System.out.print("What is the number of people expected at the pizza party? ");
    input = s.nextLine();
    //convert string input into int for calculations
    int totalPeople = Integer.parseInt(input);
    //expression is used twice, storing in variable to make printf easier to read
    //if there were < 5 people at the party then integer division would round the pizzaCount to 0
    //but adding one less than the divisor to the dividend makes integer division round that up to 1
    int pizzaCount = ((totalPeople * slicesPerPerson) + (totalSlices - 1))/totalSlices;
    //display results
    System.out.printf("For %d people, that would be %d pizza(s) with everyone having %d slices each. There would be %d slice(s) leftover\n",
                      totalPeople, pizzaCount, slicesPerPerson, (pizzaCount * totalSlices) - (slicesPerPerson * totalPeople));
  }
}
