import java.util.*;

public class FrequencySort {

    public static void sortByFrequency(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Convert to Integer array for sorting
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Sort based on frequency
        Arrays.sort(nums, (a, b) -> {
            int freqCompare = freqMap.get(b) - freqMap.get(a);
            if (freqCompare == 0) {
                return a - b; // optional: smaller number first
            }
            return freqCompare;
        });

        // Print result
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 5, 4, 3};
        sortByFrequency(arr);
    }
}