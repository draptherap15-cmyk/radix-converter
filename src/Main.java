import java.util.Scanner;

/**
 * Main Application Class
 * Handles Input → Process → Output flow for the Radix Converter
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Radix Conversion Calculator ===");
        System.out.println("Supported bases: 2-36 (Binary, Octal, Decimal, Hexadecimal, etc.)");
        System.out.println();

        while (running) {
            try {
                // INPUT
                System.out.print("Enter the number to convert: ");
                String number = scanner.nextLine().trim();

                if (number.isEmpty()) {
                    System.out.println("Input cannot be empty. Try again.\n");
                    continue;
                }

                System.out.print("Enter the source base (2-36): ");
                int fromBase = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Enter the target base (2-36): ");
                int toBase = Integer.parseInt(scanner.nextLine().trim());

                // PROCESS
                String result = RadixConverter.convert(number, fromBase, toBase);

                // OUTPUT
                System.out.println();
                System.out.println("--- Conversion Result ---");
                System.out.println(number + " (" + RadixConverter.getBaseName(fromBase) + ") = " + result + " (" + RadixConverter.getBaseName(toBase) + ")");
                System.out.println();

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers for the bases.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }

            // Ask for another conversion
            System.out.print("Convert another number? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                running = false;
            }
            System.out.println();
        }

        scanner.close();
        System.out.println("Thank you for using Radix Converter!");
    }
}
