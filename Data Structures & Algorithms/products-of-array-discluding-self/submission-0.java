class Solution {
    public void productExceptSelfWithDivision(int[] nums) {
        int[] nums1 = new int[nums.length];
        int prod = 1;
        for (int num : nums) {
            prod *= num;
        }
        for (int i=0; i < nums.length; i++) {
            nums1[i] = (prod / nums[i]);
        }
        return;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        Arrays.fill(left, 1);
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i=1; i < nums.length; i++) {
            left[i] = (left[i-1] * nums[i-1]);
        }
        for (int i=(nums.length-2); i >=0; i--) {
            res[i] = (nums[i+1] * res[i+1]);
        }
        for (int i=0; i < nums.length; i++) {
            res[i] *= left[i];
        }
        return res;
    }
}  
