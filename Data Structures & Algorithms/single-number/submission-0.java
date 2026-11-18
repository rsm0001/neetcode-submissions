class Solution {
    public int singleNumber(int[] nums) {
        int resnum = 0;
        for (int num : nums) {
            resnum ^= num;
        }
        return resnum;
    }
}
