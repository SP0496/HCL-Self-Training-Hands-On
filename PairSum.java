import java.util.*;

public class PairSum {

    public static void findPairs(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        System.out.println("Pairs:");
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println(arr[left] + ", " + arr[right]);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int target = 6;

        findPairs(arr, target);
    }
}