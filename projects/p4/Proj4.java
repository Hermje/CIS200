import java.io.*;
import java.util.*;

/*
 * Proj4.java
 *
 * Jake Herman/Thursday Lab (4:30)
 *
 * Image Verifier: takes a simple image of characters and counts up each bit in every row and column
 * to make sure that they contain an even number of 1's. If there is an odd count, the image was modified.
 * This program will alert the user of that, and if there is only one error we can correct it.
 *
 */

public class Proj4 {

  public static void main(String[] args) throws IOException
  {
    int width = 0;
    int height = 0;
    char[][] image = new char[0][0];

    Scanner userIn = new Scanner(System.in);
    //prompt user to enter filename, they must include the extension
    System.out.print("Enter the name of the input file: ");

    Scanner file = new Scanner(new File(userIn.nextLine()));
    int lineNumber = 0;
    while(file.hasNext())
    {
      String line = file.nextLine();
      lineNumber++;
      //each file has the size at the top so before declaring the array, read that in
      if(lineNumber == 1)
      {
        String[] dimensions = line.split("x");
        height = Integer.parseInt(dimensions[0]);
        width = Integer.parseInt(dimensions[1]);
        //now that height and width have been read in, create a 2D array of that size
        image = new char[height][width];
      }
      //read in lines of file to image, all files have a newline after the dimensions so wait til line 3
      if(lineNumber >= 3)
      {
        char[] lineChars = line.toCharArray();

        for(int i = 0; i < lineChars.length; i++)
        {
          image[lineNumber-3][i] = line.toCharArray()[i];
        }
      }
      //we now have everything we need from the file
    }

    file.close();

    //stores the errors in rows/columns to handle user output
    int rowErrors = 0;
    int columnErrors = 0;
    //stores where the error occurred, used for correcting
    //will be overwritten if multiple errors are found, but if that is the case, the image is damaged beyond repair.
    int brokenRow = 0;
    int brokenColumn = 0;
    //look at each row for errors
    for(int i = 0; i < height - 1; i++)
    {
      char[] row = image[i];
      int bitCount = 0;
      //each character in the row
      for(char c : row)
      {
        if(c == '1')
        {
          //increment bitcount
          bitCount++;
        }
      }

      //bit count is odd that means there is an error in this row, let the user know
      if(bitCount % 2 > 0)
      {
        System.out.printf("Off at ROW %d \n", i);
        brokenRow = i;
        rowErrors++;
      }
    }

    //look through each column for errors
    for(int i = 0; i<width; i++)
    {
      //reset this for every column
      int bitCount = 0;
      //go down the column
      for(int j=0; j<height; j++)
      {
        char bit = image[j][i];

        if(bit == '1')
        {
          //1 found.. increment bit count
          bitCount++;
        }
      }
      //if the count is odd, there's an error
      if(bitCount % 2 > 0)
      {
        //let the user know
        System.out.printf("Off at COLUMN %d \n", i);
        brokenColumn = i;
        columnErrors++;
      }
    }

    if(rowErrors <= 1 && columnErrors <= 1)
    {
      System.out.println("\n The image contains many errors, it may be damaged.");
    }
    else
    {
      //only one error, repair it
      System.out.printf("\nPosition (%d,%d) was modified. Correcting...\n", brokenRow, brokenColumn);
      image[brokenRow][brokenColumn] = '1';
      //prompt user for substitutions
      System.out.print("What symbol would you like to use for white? ");
      char white = userIn.nextLine().charAt(0);
      System.out.print("What symbol would you like to use for black? ");
      char black = userIn.nextLine().charAt(0);
      //make substitutions by iterating through each symbol in the image
      for(int i = 0; i<height; i++)
      {
        for(int j=0; j<width; j++)
        {
          //assuming 1 is white and 0 is black we substitute the bit at that point in the image
          if(image[i][j] == '1')
          {
            image[i][j] = white;
          }
          else
          {
            image[i][j] = black;
          }
        }
      }
    }

    //final output
    System.out.printf("this is your image: %d x %d \n", height, width);
    //iterate through each bit to display the image
    //subtracting 1 from the dimensions to avoid pairity bits
    for(int i=0; i<height - 1; i++) {
      for(int j=0; j<width - 1; j++) {
        System.out.print(image[i][j]);
      }
      System.out.print("\n");
    }
  }

}
