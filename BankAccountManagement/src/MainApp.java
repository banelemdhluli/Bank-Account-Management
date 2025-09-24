import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class MainApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BankAccountManagement account = new DepositMoney(); // to initialize shared fields

        try {
            // Account Holder Name
            while (true) {
                System.out.println();
                System.out.print("Welcome to Standard Bank !!");
                System.out.print("\nLet us create an account for you");
                System.out.println();
                System.out.print("Enter account holder name: ");
                String name = input.nextLine();
                if (name.trim().isEmpty() || !name.matches("[a-zA-Z ]+")) {
                    System.out.println("Invalid input. Only letters allowed.");
                } else {
                    account.setAccHolderName(name);
                    break;
                }
            }

            // Account Number
            Random random = new Random();
            int firstDigit = random.nextInt(9) + 1; // 1–9
            StringBuilder accountNumber = new StringBuilder();
            accountNumber.append(firstDigit);
            for (int i = 0; i < 9; i++) {
                accountNumber.append(random.nextInt(10));
            }
            account.setAccNumber(accountNumber.toString());
            System.out.println("Account Number: " + accountNumber.toString());

            // PIN
            while (true) {
                System.out.print("Enter card PIN: ");
                String pin = input.nextLine();

                if (pin.trim().isEmpty() || !pin.matches("\\d+")) {
                    System.out.println("Pin number must contain only digits.");
                } else {
                    account.setCardPin(pin);
                    break;
                }
            }

            System.out.println("\nAccount created successfully for " + account.getAccHolderName());

            // Menu loop with input validation
            while (true) {
                System.out.println("\n1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Check Balance");
                System.out.println("0. Exit");
                System.out.print("Choose option: ");

                String choice;

                    choice = input.nextLine();

                    if (choice.trim().isEmpty() || !choice.matches("\\d+")) {
                        System.out.println("Invalid input please try again.");
                    continue;
                }

                BankAccountManagement action = null;

                switch (choice) {
                    case "1":
                        action = new DepositMoney();
                        break;
                    case "2":
                        action = new WithdrawMoney();
                        break;
                    case "3":
                        action = new CheckBalance();
                        break;
                    case "0":
                        System.out.println();
                        System.out.println("Goodbye!");
                        System.out.println("App exiting....");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }

                // Share account state across subclasses
                action.setAccHolderName(account.getAccHolderName());
                action.setAccNumber(account.getAccNumber());
                action.setCardPin(account.getCardPin());
                action.balance = account.balance;

                action.performAction(input);

                // Update main account balance
                account.balance = action.balance;
            }

        } catch (Exception e) {
            System.out.println("Unexpected error occurred.");
        }
    }
}
