public class PatternMatching {

    public static boolean isPatternPresent(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // loop through all possible starting points
        for (int i = 0; i <= n - m; i++) {
            int j;

            // compare substring
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            // if full match found
            if (j == m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String text = "hello world";
        String pattern = "world";

        boolean result = isPatternPresent(text, pattern);

        System.out.println("Pattern Found: " + result);
    }
}