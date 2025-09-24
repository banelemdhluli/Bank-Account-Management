import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DepositMoney extends BankAccountManagement {

    @Override
    public void performAction(Scanner input) {

        // 🔐 Ask for PIN before continuing
        while (true) {
            System.out.println();
            System.out.print("Enter your card PIN to deposit (or type '0' to go back): ");
            String enteredPin = input.nextLine();

            if (enteredPin.equals("0")) {
                System.out.println("Deposit cancelled. Returning to main menu...");
                return;
            }

            if (!enteredPin.equals(this.getCardPin())) {
                System.out.println("❌ Wrong PIN. Try again.\n");
            } else {
                System.out.println("✅ PIN verified.");
                break;
            }
        }


            // Deposit section
            while (true) {
                try {
                    System.out.println();
                    System.out.print("Please deposit money: ");
                    double amount = input.nextDouble();
                    input.nextLine(); // clear buffer

                    if (amount <= 40) {
                        System.out.println("Cannot deposit less than R40. Try again.\n");
                    } else {
                        balance += (amount - 20); // deposit fee R20
                        System.out.println("Money deposited successfully!");
                        System.out.println("Deposit fee: R20");
                        System.out.println("Current Balance: R" + balance);

                        System.out.println();

                        // Current date and time
                        DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                        LocalDateTime now = LocalDateTime.now(); // Get current date and time

                        String formattedDate = now.format(myDateFormat); // Format it into a string

                        System.out.println(formattedDate);

                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input please enter a number.");
                    input.nextLine();
                }
            }
        }
    }
