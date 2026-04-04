import java.util.regex.*;

public class EmailValidator {

    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("test.user@example.com")); // true
        System.out.println(isValidEmail("invalid@.com")); // false
    }
}