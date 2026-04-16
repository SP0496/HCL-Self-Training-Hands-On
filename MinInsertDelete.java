public class MinInsertDelete {

    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // build LCS table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";

        int lcsLength = lcs(s1, s2);

        int deletions = s1.length() - lcsLength;
        int insertions = s2.length() - lcsLength;

        System.out.println("LCS Length: " + lcsLength);
        System.out.println("Deletions: " + deletions);
        System.out.println("Insertions: " + insertions);
    }
}