class Solution {
    public int rob(int[] nums) {
        if (nums.length > 0) {
            int last = (nums.length - 1);
            int[] maxsum = new int[4];
            maxsum[0] = maxsum[1] = maxsum[2] = 0;
            for (int i=0; i <= last; i++) {
                maxsum[3] = (nums[i] + Math.max(maxsum[0], maxsum[1]));
                maxsum[0] = maxsum[1]; maxsum[1] = maxsum[2]; maxsum[2] = maxsum[3];
            }
            return Math.max(maxsum[1], maxsum[3]);
        }
        return 0;
    }
}
