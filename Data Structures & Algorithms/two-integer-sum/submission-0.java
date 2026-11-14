class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int indx1 = -1, indx2 = -1;
        for (int i=0; i < nums.length; i++) {
            int cmpl = (target - nums[i]);
            if (map.containsKey(cmpl)) {
                indx1 = i; indx2 = map.get(cmpl);
                break;
            }
            map.put(nums[i], i);
        }
        return new int[]{Math.min(indx1, indx2), Math.max(indx1, indx2)};
    }
}
