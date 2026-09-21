import java.util.Scanner;

/**
 * Radix Conversion Calculator
 * Single-file version: Input -> Process -> Output
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Radix Conversion Calculator ===");
        System.out.println("Supported bases: 2-36");
        System.out.println("Examples: Binary(2), Octal(8), Decimal(10), Hexadecimal(16)");
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
                String result = convert(number, fromBase, toBase);

                // OUTPUT
                System.out.println();
                System.out.println("--- Conversion Result ---");
                System.out.println(formatValue(number, fromBase) + " = " + formatValue(result, toBase));
                System.out.println();

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers for the bases.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }

            System.out.print("Convert another number? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                running = false;
            }
            System.out.println();
        }

        scanner.close();
        System.out.println("Thank you for using the Radix Converter!");
    }

    /** Converts a number from one radix to another. */
    public static String convert(String number, int fromBase, int toBase) {
        if (fromBase < 2 || fromBase > 36 || toBase < 2 || toBase > 36) {
            throw new IllegalArgumentException("Radix bases must be between 2 and 36");
        }

        try {
            long decimalValue = Long.parseLong(number.toUpperCase(), fromBase);
            return Long.toString(decimalValue, toBase).toUpperCase();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number for base " + fromBase + ": " + number);
        }
    }

    /**
     * Formats decimal values normally and other bases using standard radix notation.
     * Examples: 10, (1010)₂, (17)₈, (FF)₁₆.
     */
    public static String formatValue(String value, int base) {
        if (base == 10) {
            return value;
        }
        return "(" + value + ")" + toSubscript(base);
    }

    /** Converts the digits of a base number to Unicode subscript characters. */
    public static String toSubscript(int number) {
        String digits = String.valueOf(number);
        StringBuilder result = new StringBuilder();

        for (char digit : digits.toCharArray()) {
            switch (digit) {
                case '0': result.append('₀'); break;
                case '1': result.append('₁'); break;
                case '2': result.append('₂'); break;
                case '3': result.append('₃'); break;
                case '4': result.append('₄'); break;
                case '5': result.append('₅'); break;
                case '6': result.append('₆'); break;
                case '7': result.append('₇'); break;
                case '8': result.append('₈'); break;
                case '9': result.append('₉'); break;
                default: result.append(digit);
            }
        }
        return result.toString();
    }
}
