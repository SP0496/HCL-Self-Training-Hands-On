public class SubsetSum {

    public static boolean subsetSum(int[] arr, int target) {
        int n = arr.length;

        // total subsets = 2^n
        int total = 1 << n;

        for (int mask = 0; mask < total; mask++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                // check if i-th element is included
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                }
            }

            if (sum == target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 9};
        int target = 8;

        boolean result = subsetSum(arr, target);

        System.out.println("Subset Exists: " + result);
    }
}