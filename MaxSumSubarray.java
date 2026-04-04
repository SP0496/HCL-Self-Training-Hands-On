public class MaxSumSubarray {

    public static int maxSum(int[] arr, int k) {
        int sum = 0, maxSum;

        // first window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        maxSum = sum;

        // sliding window
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println("Max Sum: " + maxSum(arr, k));
    }
}