import java.util.regex.*;

public class PhoneExtractor {

    public static void extractPhones(String text) {
        String regex = "(\\+\\d{1,3}[\\s-]?)?\\(?\\d{3}\\)?[\\s-]?\\d{3}[\\s-]?\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        String text = "Call me at 9876543210 or +91 98765-43210 or (123) 456-7890";
        extractPhones(text);
    }
}