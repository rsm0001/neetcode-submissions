class Solution {
    // my solution was simplified
    public int jump(int[] nums) {
        int nstep = 0, next = 0, dist = 0;
        if (nums.length > 1) {
            for (int i=0; i < nums.length; i++) {
                dist = Math.max(dist, (i + nums[i]));
                if (dist >= (nums.length - 1)) { nstep++; break; }
                if (i == next) {
                    next = dist; nstep++;
                }
            }
        }
        return nstep;
    }
}
