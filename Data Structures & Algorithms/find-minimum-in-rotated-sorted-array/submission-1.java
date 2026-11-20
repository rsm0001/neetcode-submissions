class Solution {
    // My solution was simplified. The key point is that when the array is
    // rotated, the max element is either to the left or to the right of 
    // the middle element. If the last element is less than the middle
    // element, then the peak element is either the middle element or to
    // the right of the middle element. This make it easier to search.
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return nums[low];
    }
}
