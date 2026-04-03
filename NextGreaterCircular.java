import java.util.*;

public class NextGreaterCircular {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        // Traverse 2 times (circular)
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;

            // Resolve elements in stack
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                result[stack.pop()] = nums[index];
            }

            // Only push in first round
            if (i < n) {
                stack.push(index);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};

        int[] res = nextGreaterElements(arr);

        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}