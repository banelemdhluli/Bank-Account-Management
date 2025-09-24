import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckBalance extends BankAccountManagement {

    @Override
    public void performAction(Scanner input) {

         // Ask for PIN before continuing
        while (true) {
            System.out.println();
            System.out.print("Enter your card PIN to view balance (or type '0' to go back): ");
            String enteredPin = input.nextLine();

            if (enteredPin.equals("0")) {
                System.out.println("Returning to main menu...");
                return;
            }

            if (enteredPin.equals(this.getCardPin())) {
                System.out.println("✅ PIN verified.");
                System.out.println("Your current balance is: R" + balance); // Display current balance

                System.out.println();

                // Current date and time
                DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                LocalDateTime now = LocalDateTime.now(); // Get current date and time

                String formattedDate = now.format(myDateFormat); // Format it into a string

                System.out.println(formattedDate); // Print the formatted date and time


                break;
            } else {
                System.out.println("❌ Wrong PIN. Try again.\n");


            }
        }
    }
}