public class ReverseStringRecursion {

    public static String reverse(String str) {
        // base case
        if (str.isEmpty()) {
            return str;
        }

        // recursive call
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String input = "hello";

        String result = reverse(input);

        System.out.println("Reversed String: " + result);
    }
}