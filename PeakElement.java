class PeakElement {

    public static void main(String[] args) {
        PeakElement obj = new PeakElement();
        int[] nums = {1, 2, 3, 1};

        int index = obj.findPeakElement(nums);
        System.out.println(index);
    }

    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}