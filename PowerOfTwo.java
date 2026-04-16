public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 16;

        boolean result = isPowerOfTwo(n);

        System.out.println("Is Power of Two: " + result);
    }
}
