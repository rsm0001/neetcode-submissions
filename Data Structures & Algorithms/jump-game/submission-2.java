class Solution {
    // my solution was simplified
    public boolean canJump(int[] nums) {
        int nstep = 0, next = 0, dist = 0, last = (nums.length - 1);
        for (int i=0; i < nums.length; i++) {
            dist = Math.max(dist, (i + nums[i]));
            if (i == next) {
                if (dist >= last) { return true; }
                nstep++; next = dist;
            }
        }
        return false;
    }
}
