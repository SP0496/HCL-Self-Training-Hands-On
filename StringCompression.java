public class StringCompression {

    public static String compress(String s) {
        if (s == null || s.length() == 0) return "";

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        // last character
        result.append(s.charAt(s.length() - 1)).append(count);

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "aaabb";
        System.out.println(compress(input));
    }
}