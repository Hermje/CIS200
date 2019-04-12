import java.util.*;
import java.io.*;

/*
 *  Author: Jake Herman
 *  (Thurs lab 4:30-6:20)
 *
 *  Palindrome Finder: Takes in a file full of various words and then
 *  creates a file full of palindromes found in the input.
 *
 *  Also, when I was testing this program with Testfile2.txt, the file could not
 *  be read because the apostrophes in the file were some weird symbol when I downloaded
 *  from canvas. I changed those symbols to apostrophes and it worked fine.
 *
 */

public class Proj5 {

  public static void main(String[] args) throws IOException
  {
    //pass the result of getFileInfo into readFile to get the words contained in the input file
    String[] words = readFile(getFileInfo());
    //stores all words that are palindromes, used to store then sort
    String[] palindromes = new String[words.length];
    //print writer object is passed into the saving methods so file is not overwritten when data is appended
    PrintWriter pw = new PrintWriter(new FileWriter("results.txt"));
    //stats for the input file to be included at the end of the output
    int characterCount = 0;
    int totalLines = 0;
    int totalWordCount = 0;
    //increments every time a palindrome is found
    int palindromeCount = 0;
    //iterate over the words in the input file
    for(String word : words)
    {
      //increment stats
      characterCount += word.toCharArray().length;
      totalLines += 1;
      totalWordCount += word.split(" ").length;
      //make sure the word has no punctuation, spaces and is forced into lowercase
      String normalizedWord = normalizeWord(word);
      //check if word is a palindrome, passing result of reverseWord into isPalindrome
      if(isPalindrome(normalizedWord, reverseWord(normalizedWord)))
      {
        //word is a palindrome, write it to the file without normalization
        System.out.printf("%s IS a palindrome\n", word);
        palindromes[palindromeCount] = word;
        palindromeCount++;
        //saveLine(word, pw);
      }
      else
      {
        //not a palindrome, nothing needs to be done with it. let the user know..
        System.out.printf("%s is NOT a palindrome\n", word);
      }
    }

    //palindromes = sortArray(palindromes, palindromeCount);
    palindromes = sortArray(new String[] {"b", "a", "f", "d", "e", "c"}, 6);
    for(String palindrome : palindromes)
    {
      System.out.println(palindrome);
      saveLine(palindrome, pw);
    }

    //write final stats to the output file
    saveResults(characterCount, totalLines, ((double) totalWordCount/totalLines), pw);
    //close buffer and save output file (results.txt)
    pw.close();
  }

  /** getFileInfo
   *
   *  Prompts the user to enter the file name to get the file for processing.
   *
   *  @return the file object of the file the user is referring to
   */

  public static File getFileInfo() throws IOException
  {
    //prompt user to enter file name
    Scanner userIn = new Scanner(System.in);
    System.out.print("Enter name of the file: ");
    //starting by creating File object so I can use .exists(), passed into Scanner later..
    File file = new File(userIn.nextLine());
    //continue prompting user for the file name until it is found
    while(!file.exists())
    {
      System.out.println("File not found..");
      System.out.print("Enter name of the file: ");
      file = new File(userIn.nextLine());
    }

    return file;
  }

  /** readFile
   *
   *  Prompts the user to enter the file name to get the file for processing.
   *
   *  @param file file object to be processed
   *  @return a string array of all words in the input file
   */

  public static String[] readFile(File file) throws IOException
  {
    /*
     * I need the line count to properly size the array that stores all words.
     * Can't read the file and expand ARRAY at the same time (ArrayList would be nice...)
     * so I'm creating a copy of the file (temp file) to count the lines.
     */
    Scanner tempFile = new Scanner(file);
    int lineCount = 0;
    //count lines
    while(tempFile.hasNext())
    {
      lineCount++;
      tempFile.nextLine();
    }
    //close temp file buffer, no longer needed
    tempFile.close();

    Scanner goodFile = new Scanner(file);
    //create array with lineCount size to store words in
    String[] words = new String[lineCount];

    lineCount = 0;
    //store words int words array
    while(goodFile.hasNext())
    {
      words[lineCount] = goodFile.nextLine();
      lineCount++;
    }
    //close buffer
    goodFile.close();

    return words;
  }

  /** normalizeWord
   *
   *  Makes sure every word is in the same state before checking whether or not it is a palindrome.
   *
   *  @param word the word (String) to be normalized
   *  @return String word, without spaces, punctuation, or captial letters
   */

  public static String normalizeWord(String word)
  {
    StringBuilder newWord = new StringBuilder();
    //regex to split on any punctuation/space | basically says "or" and allows for multiple delimiters
    String[] tempWord = word.split("\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*| |/");
    //the word currently may be split into multiple parts, so iterate over the array and turn it into one string
    for(String splitWord : tempWord)
    {
      newWord.append(splitWord);
    }

    return newWord.toString().toLowerCase();
  }

  /** reverseWord
   *
   *  Reverses input to be used to check if the normal word is a palindrome.
   *
   *  @param word the word (String) to be reversed
   *  @return the String input backwards
   */

  public static String reverseWord(String word)
  {
    char[] wordChars = word.toCharArray(); //array where each element is a character in the word
    StringBuilder wordBackwards = new StringBuilder(); //using StringBuilder for the append method
    //iterate over the word backwards and build a new string with string builder
    for(int i = word.length()-1; i >= 0; i--)
    {
      wordBackwards.append(wordChars[i]);
    }

    return wordBackwards.toString();
  }

  /** isPalindrome
   *
   *  Checks if word is a palindrome.
   *
   *  @param word normal word
   *  @param wordBackwards word backwards (result of reverseWord)
   *  @return true or false based on whether or not the word is a palindrome
   */

  public static boolean isPalindrome(String word, String wordBackwards)
  {
    //wordBackwards is just the reverse of word so use the equals method to compare strings
    if(word.equals(wordBackwards))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /** saveLine
   *
   *  Saves a line to the output file (results.txt).
   *
   *  @param line the line to be saved (a valid palindrome)
   *  @param pw the PrintWriter object to be reused so the file is not overwritten and lines can just be appended.
   */

  public static void saveLine(String line, PrintWriter pw)
  {
    //write line to output file
    pw.println(line);
  }

  /** saveResults
   *
   *  Saves final results (stats of input file) to output file.
   *
   *  @param characterCount the character count of the input file
   *  @param lineCount the line count of the input file
   *  @param avgWordsPerLine the average of words per line of the input file
   *  @param pw the PrintWriter object, to be reused so the file is not overwritten.
   */

  public static void saveResults(int characterCount, int lineCount, double avgWordsPerLine, PrintWriter pw)
  {
    //using saveLine method to right stats to file
    saveLine("\n\n\nInput file contained a total of " + characterCount + " characters", pw);
    saveLine("Input file contained a total of " + lineCount + " lines", pw);
    saveLine("Input file contained " + avgWordsPerLine + " words per line on average", pw);
  }
}
