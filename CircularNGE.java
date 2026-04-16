import java.util.*;

public class CircularNGE {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        // traverse twice for circular array
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        int[] res = nextGreaterElements(nums);

        System.out.println("Next Greater Elements:");
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
