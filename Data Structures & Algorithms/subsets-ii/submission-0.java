class Solution {
    private void subsets(int[] nums, List<List<Integer>> reslist, List<Integer> nlist, int pos) {
        for (int i=pos; i < nums.length; i++) {
            if ((i > pos) && (nums[i] == nums[i-1])) { continue; }
            nlist.add(nums[i]);
            reslist.add(new ArrayList<>(nlist));
            subsets(nums, reslist, nlist, (i+1));
            nlist.removeLast();
        }
        return;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> reslist = new ArrayList<>();
        reslist.add(new ArrayList<>());
        if (nums.length > 0) {
            Arrays.sort(nums);
            List<Integer> nlist = new ArrayList<>();
            subsets(nums, reslist, nlist, 0);
        }
        return reslist;
    }
}
