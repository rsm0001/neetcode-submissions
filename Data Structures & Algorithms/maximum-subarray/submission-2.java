class Solution {
    // I thought for a bit and this is the key to the solution:
    // if ((sum + nums[i]) < nums[i]) {
    public int maxSubArray(int[] nums) {
        int maxsum = ((nums.length > 0) ? nums[0] : 0);
        if (nums.length > 1) {
            int sum = nums[0];
            for (int i=1; i < nums.length; i++) {
                if (((sum + nums[i]) < sum) || ((sum + nums[i]) < nums[i])) {
                    maxsum = Math.max(maxsum, sum);
                }
                if ((sum + nums[i]) < nums[i]) { sum = 0; }
                sum += nums[i];
            }
            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;
    }
}
