class Solution {
    private boolean isMin(int[] nums, int pos) {
        int last = (nums.length - 1);
        int prev = ((0 == pos) ? last : (pos - 1));
        int next = ((last == pos) ? 0 : (pos + 1));
        return ((nums[pos] < nums[prev]) && (nums[pos] < nums[next]));
    }

    private int findMin(int[] nums, int low, int high) {
        int minval = Integer.MAX_VALUE;
        if (low <= high) {
            int mid = (low + ((high - low)/2));
            if (isMin(nums, mid)) { minval = nums[mid]; }
            else {
                int lmin = findMin(nums, low, (mid-1));
                if (lmin < Integer.MAX_VALUE) { minval = lmin; }
                else { minval = findMin(nums, (mid+1), high); }
            }
        }
        return minval;
    }

    public int findMin(int[] nums) {
        int minval = Integer.MAX_VALUE;
        switch (nums.length) {
            case 0: // not expected - is an error
            break;
            case 1: minval = nums[0]; break;
            case 2: minval = Math.min(nums[0], nums[1]); break;
            default: minval = findMin(nums, 0, (nums.length - 1)); break;
        }
        return minval;
    }
}
