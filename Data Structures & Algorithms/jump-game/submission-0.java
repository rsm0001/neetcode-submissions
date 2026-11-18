class Solution {
    public boolean canJump(int[] nums) {
        int last = (nums.length - 1);
        Set<Integer> set = new HashSet<>();
        if (nums.length > 0) {
            boolean nochange = false;
            set.add(0);
            while ((! nochange) && (! set.contains(last))) {
                nochange = true;
                List<Integer> list = new ArrayList<>(set);
                set.clear();
                for (int pos : list) {
                    for (int i=1; i <= nums[pos]; i++) {
                        if ((pos+i) >= nums.length) { break; }
                        if (last == (pos+i)) { return true; }
                        nochange = false; set.add(pos+i);
                    }
                }
            }
        }
        return set.contains(last);
    }
}
