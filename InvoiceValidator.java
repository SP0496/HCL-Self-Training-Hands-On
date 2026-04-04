import java.util.regex.*;

public class InvoiceValidator {

    public static boolean isValidInvoice(String invoice) {
        String regex = "^INV-(\\d{4})(0[1-9]|1[0-2])-(\\d{6})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(invoice);

        if (matcher.matches()) {
            // Extract parts
            String year = matcher.group(1);
            String month = matcher.group(2);
            String serial = matcher.group(3);

            // (Optional) Checksum stub
            // Example: simple check → serial not all zeros
            return !serial.equals("000000");
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidInvoice("INV-202511-000123")); // true
        System.out.println(isValidInvoice("INV-202513-000123")); // false (invalid month)
    }
}