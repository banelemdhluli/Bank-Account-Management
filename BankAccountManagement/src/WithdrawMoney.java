import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WithdrawMoney extends BankAccountManagement {

    @Override
    public void performAction(Scanner input) {

        // 🔐 Ask for PIN before continuing
        while (true) {
            System.out.println();
            System.out.print("Enter your card PIN to withdraw (or type '0' to go back): ");
            String enteredPin = input.nextLine();

            if (enteredPin.equals("0")) {
                System.out.println("Withdrawal cancelled. Returning to main menu...");
                return;
            }

            if (!enteredPin.equals(this.getCardPin())) {
                System.out.println("❌ Wrong PIN. Try again.\n");
            } else {
                System.out.println("✅ PIN verified.");
                break;
            }
        }

        // 💵 Withdrawal Section
        while (true) {
            System.out.println();

            if (balance <= 0) {
                System.out.println("Current balance: R" + balance);
                System.out.println("You must have money first before you withdraw!");
                break;
            }

            final double withdrawalFee = 10.0; // 💰 Fixed withdrawal fee

            while (true) {
                try {
                    System.out.println();
                    System.out.print("You have R" + balance + " in your account");
                    System.out.print("\nEnter amount to withdraw: ");
                    double amount = input.nextDouble();
                    input.nextLine(); // clear buffer

                    double totalDeduction = amount + withdrawalFee;

                    // Validate input
                    if (amount <= 0) {
                        System.out.println("❌ Amount must be greater than R0.");
                    } else if (amount < 10) {
                        System.out.println("❌ Amount cannot be less than R10.");
                    } else if (totalDeduction > balance) {
                        System.out.println("❌ Insufficient funds. You need R" + totalDeduction + " including the R10 fee.");
                    } else {
                        double remaining = balance - totalDeduction;

                        if (remaining < 10) {
                            System.out.println("⚠️ You must keep at least R10 for your account to operate.");
                        } else {
                            balance -= totalDeduction;

                            System.out.println("✅ Withdrawal successful.");
                            System.out.println();
                            System.out.println("Withdrawn Amount: R" + amount);
                            System.out.println("Withdrawal Fee: R" + withdrawalFee);
                            System.out.println("Remaining Balance: R" + balance);

                            System.out.println();

                            // Current date and time
                            DateTimeFormatter myDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                            LocalDateTime now = LocalDateTime.now(); // Get current date and time

                            String formattedDate = now.format(myDateFormat); // Format it into a string

                            System.out.println(formattedDate); // Print the formatted date and time

                            break;
                        }
                    }

                } catch (Exception e) {
                    System.out.println("⚠️ Invalid input please enter a valid number.");
                    input.nextLine(); // clear invalid input
                }
            }

            break; // After successful withdrawal or failure, break from outer loop
        }
    }
}



