import java.io.*;
import java.util.*;

public class Proj4 {

  public static void main(String[] args) throws IOException
  {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter the name of a file you'd like to be processed: ");

    Scanner s = new Scanner(new File(in.nextLine()));
    int lineNumber = 0;
    while(s.hasNext())
    {
      String line = s.nextLine();
      lineNumber++;
      //each file has the size at the top so before declaring the array, read that in
      int width = 0;
      int height = 0;
      if(lineNumber == 1)
      {
        char[] dimensions = line.toCharArray();
        boolean heightFound = false;
        for(char c : dimensions)
        {
          if(Character.isDigit(c))
          {
            if(heightFound)
            {
              width = Integer.parseInt(Integer.toString(width) + Character.toString(c));
            }
            else
            {
              height = Integer.parseInt(Integer.toString(height)+ Character.toString(c));
            }
          }
          else
          { //if we run into 'x'
            heightFound = true;
          }
        }
      }
      //now that height and width have been read in, create a 2D array of that size
      char[][] image = new char[height][width];

    }

    s.close();
  }

}
