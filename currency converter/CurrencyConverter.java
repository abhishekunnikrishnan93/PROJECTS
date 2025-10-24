package currencyconvert;
import java.util.Scanner;

class CurrencyConverter {

    String[] currencies = {"USD", "EUR", "INR", "SAR", "JPY"};
    Scanner sc = new Scanner(System.in);

    void start() {
        boolean continueConversion = true;

        while (continueConversion) {
            // Display currencies manually
            System.out.println("\nAvailable currencies:");
            System.out.println("1. USD");
            System.out.println("2. EUR");
            System.out.println("3. INR");
            System.out.println("4. SAR");
            System.out.println("5. JPY");

            // Source currency selection
            int sourceChoice;
            while (true) {
                System.out.print("Choose source currency (1-" + currencies.length + "): ");
                sourceChoice = sc.nextInt() - 1;
                if (sourceChoice >= 0 && sourceChoice < currencies.length) {
                    break;
                } else {
                    System.out.println("Invalid option, try again.");
                }
            }

            // Target currency selection
            int targetChoice;
            while (true) {
                System.out.print("Choose target currency (1-" + currencies.length + "): ");
                targetChoice = sc.nextInt() - 1;
                if (targetChoice >= 0 && targetChoice < currencies.length) {
                    break;
                } else {
                    System.out.println("Invalid option, try again.");
                }
            }

            // Enter exchange rate
            System.out.print("Enter exchange rate (1 " + currencies[sourceChoice] + " = ? " + currencies[targetChoice] + "): ");
            double rate = sc.nextDouble();

            // Enter amount
            System.out.print("Enter amount in " + currencies[sourceChoice] + ": ");
            double amount = sc.nextDouble();

            // Conversion
            double converted = amount * rate;
            System.out.println(amount + " " + currencies[sourceChoice] + " = " + converted + " " + currencies[targetChoice]);

            // Ask to continue
            while (true) {
                System.out.print("Do you want to continue? (yes/no): ");
                String ans = sc.next();
                if (ans.equalsIgnoreCase("yes")) {
                    break; // go back to start of main loop
                } else if (ans.equalsIgnoreCase("no")) {
                    continueConversion = false;
                    break;
                } else {
                    System.out.println("Invalid input, please type yes or no.");
                }
            }
        }

        System.out.println("Thank you for using Currency Converter!");
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        converter.start();
    }
}