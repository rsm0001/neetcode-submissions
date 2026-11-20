class Solution {
    private int findMin(int[]nums) {
        int low = 0, high = (nums.length - 1);
        while (low < high) {
            int mid = (low + ((high - low) / 2));
            if (nums[mid] > nums[high]) { low = (mid + 1); }
            else { high = mid; }
        }
        return low;
    }

    private int search(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + ((high - low) / 2));
            if (target == nums[mid]) { return mid; }
            else if (target < nums[mid]) { high = (mid - 1); }
            else { low = (mid + 1); }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        switch (nums.length) {
            case 1: if (target == nums[0]) { return 0; } break;
            default:
                int low = findMin(nums), last = (nums.length - 1);
                if ((target >= nums[low]) && (target <= nums[last])) {
                    return search(nums, target, low, last);
                }
                return search(nums, target, 0, (low - 1));
        }
        return -1;
    }
}
