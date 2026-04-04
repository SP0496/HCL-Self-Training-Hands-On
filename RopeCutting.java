class RopeCutting {

    public double maxLength(int[] ropes, int k) {
        double low = 0;
        double high = getMax(ropes);

        // precision loop (important for decimal answers)
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2;

            if (canCut(ropes, k, mid)) {
                low = mid;   // try bigger length
            } else {
                high = mid;  // reduce length
            }
        }
        return low;
    }

    private boolean canCut(int[] ropes, int k, double len) {
        int pieces = 0;

        for (int rope : ropes) {
            pieces += (int)(rope / len);
        }
        return pieces >= k;
    }

    private double getMax(int[] ropes) {
        int max = 0;
        for (int r : ropes) {
            max = Math.max(max, r);
        }
        return max;
    }

    public static void main(String[] args) {
        RopeCutting obj = new RopeCutting();

        int[] ropes = {4, 7, 9};
        int k = 5;

        double result = obj.maxLength(ropes, k);

        System.out.printf("Max Length: %.2f\n", result);
    }
}