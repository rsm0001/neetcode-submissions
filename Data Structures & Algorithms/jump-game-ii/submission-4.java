class Solution {
    // my solution was simplified
    public int jump(int[] nums) {
        int jumps = 0, end = 0, far = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);  // farthest reach of next level
            if (i == end) {                    // finished current level
                jumps++;
                end = far;
            }
        }
        return jumps;
    }
}
