/**
 * Radix Converter - Converts numbers between different number systems
 * Simple but effective: Input → Process → Output
 */
public class RadixConverter {

    /**
     * Converts a number from one radix base to another
     * @param number The input number as a string
     * @param fromBase The source radix base (2-36)
     * @param toBase The target radix base (2-36)
     * @return The converted number as a string
     */
    public static String convert(String number, int fromBase, int toBase) {
        // Validate bases
        if (fromBase < 2 || fromBase > 36 || toBase < 2 || toBase > 36) {
            throw new IllegalArgumentException("Radix bases must be between 2 and 36");
        }

        try {
            // Step 1: Convert from source base to decimal (base 10)
            long decimal = Long.parseLong(number.toUpperCase(), fromBase);

            // Step 2: Convert from decimal to target base
            String result = Long.toString(decimal, toBase).toUpperCase();

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number for base " + fromBase + ": " + number);
        }
    }

    /**
     * Gets the name of a radix base
     * @param radix The radix base
     * @return The name of the base
     */
    public static String getBaseName(int radix) {
        switch (radix) {
            case 2:
                return "Binary";
            case 8:
                return "Octal";
            case 10:
                return "Decimal";
            case 16:
                return "Hexadecimal";
            default:
                return "Base-" + radix;
        }
    }
}
