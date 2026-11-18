class Solution {
    // my solution was improved
    public int maxSubArray(int[] nums) {
        int sum = nums[0], maxsum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);  // extend, or start fresh
            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;
    }
}
