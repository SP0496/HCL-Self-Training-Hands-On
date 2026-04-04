import java.util.*;

public class CoinChange {

    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // fill with large value
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // if not possible
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = minCoins(coins, amount);

        System.out.println("Minimum Coins: " + result);
    }
}