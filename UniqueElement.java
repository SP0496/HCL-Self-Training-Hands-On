public class UniqueElement {

    public static int findUnique(int[] arr) {
        int result = 0;

        for (int num : arr) {
            result ^= num;   // XOR operation
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 2, 4, 4};

        int unique = findUnique(arr);

        System.out.println("Unique Element: " + unique);
    }
}
