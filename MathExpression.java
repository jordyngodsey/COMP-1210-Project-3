import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Solves for the result of a specified expression from an input value 'x'.
 *
 * Project 3
 * @author Jordyn Godsey - COMP 1210 - 007
 * @version 2/3/22
 */
public class MathExpression
{
 /**
   * Solve for the result of an expression using input 'x'.
   *
   *@param args Command Line Arguments
   */
   public static void main(String[] args)
   {
      /* Declare variables result, user input 'x', formatting, decimal point
         index, and # characters on each side of string */
      Scanner userInput = new Scanner(System.in);
      double x, result;
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      int decimalIndex, charLeft, charRight;
      
      // Get the user input for 'x'
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      
      // Calculate and print the result
      result = 3 + (3 * x) + (3 * Math.pow(x, 2)) + (3 * Math.pow(x, 3))
               + (3 * Math.pow(x, 4));
      result = Math.sqrt(Math.abs(result)) + (3 * Math.pow(x, 5));
      result = result / (Math.abs(x) + 3);
      System.out.println("Result: " + result);
      
      // Print # of characters left of decimal place
      String resultString = Double.toString(result);
      decimalIndex = resultString.indexOf(".");
      charLeft = decimalIndex;
      System.out.println("# of characters to left of decimal point: "
               + charLeft);
      
      // Print # of characters right of decimal place
      charRight = resultString.length() - (decimalIndex + 1);
      System.out.println("# of characters to right of decimal point: "
               + charRight);
      
      // Print formatted result
      System.out.println("Formatted Result: " + df.format(result));
   }
}
