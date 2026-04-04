public class KMPPrefixFunction {

    public static int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];

        int len = 0; // previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String pattern = "ababaca";

        int[] lps = computeLPS(pattern);

        System.out.print("LPS Array: ");
        for (int x : lps) {
            System.out.print(x + " ");
        }
    }
}