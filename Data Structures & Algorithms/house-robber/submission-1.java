class Solution {
    public int rob(int[] nums) {
        if (nums.length > 0) {
            int last = (nums.length - 1);
            int[] maxsum = new int[nums.length + 3];
            maxsum[0] = maxsum[1] = maxsum[2] = 0;
            for (int i=0; i <= last; i++) {
                int j = (i + 3);
                maxsum[j] = (nums[j-3] + Math.max(maxsum[j-2], maxsum[j-3]));
            }
            return Math.max(maxsum[last+2], maxsum[last+3]);
        }
        return 0;
    }
}
