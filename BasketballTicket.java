import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
/**
 * Accepts coded ticket information as input including the price, discount,
 * time, date, section, row, seat, and the description of the ticket. The
 * information is decoded and printed in a proper ticket format, also
 * including the actual cost and a random prize number.
 *
 * Project 3
 * @author Jordyn Godsey - COMP 1210 - 007
 * @version 2/3/22
 */
public class BasketballTicket
{
 /**
   * Print coded ticket information into proper format with the actual cost
   * and a random prize number.
   *
   *@param args Command Line Arguments
   */
   public static void main(String[] args)
   {
      /* Declare variables for ticket code, decimal formatting, user input
         and random generator */
      Scanner userInput = new Scanner(System.in);
      DecimalFormat dfPrice = new DecimalFormat("$#,##0.00");
      DecimalFormat dfDiscount = new DecimalFormat("0%");
      DecimalFormat dfPrize = new DecimalFormat("000000");
      String ticketCode;
      Random generator = new Random();
      
      // Get input for ticket code
      System.out.print("Enter ticket code: ");
      ticketCode = userInput.nextLine();
      
      // Print error if ticket code is less than 28 characters
      if (ticketCode.length() < 28) {
         System.out.println("\n*** Invalid Ticket Code ***\nTicket code must "
                     + "have at least 28 characters.");
      }
      else { // Print ticket in proper format
         // Trim ticket code
         ticketCode = ticketCode.trim();
         
         // Print ticket name
         System.out.println("\nTicket: " + ticketCode.substring(27, 
                  ticketCode.length()));
         
         // Print date and time
         System.out.println("Date: " + ticketCode.substring(12, 14) + "/"
                  + ticketCode.substring(14, 16) + "/"
                  + ticketCode.substring(16, 20) + "   Time: "
                  + ticketCode.substring(8, 10) + ":"
                  + ticketCode.substring(10, 12));
         
         // Print section, row, and seat
         System.out.println("Section: " + ticketCode.substring(20, 23)
                  + "   Row: " + ticketCode.substring(23, 25)
                  + "   Seat: " + ticketCode.substring(25, 27));
         
         // Print price, discount, and cost
         double price = Double.parseDouble(ticketCode.substring(0, 6)) / 100;
         double discount = Double.parseDouble(ticketCode.substring(6, 8)) / 100;
         double cost = price - (price * discount);
         System.out.println("Price: " + dfPrice.format(price) + "   Discount: "
                  + dfDiscount.format(discount) + "   Cost: "
                  + dfPrice.format(cost));
         
         // Print prize number
         int randomNum = generator.nextInt(999999) + 1;
         System.out.println("Prize Number: " + dfPrize.format(randomNum));
      }
   }
}