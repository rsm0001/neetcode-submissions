class Solution {
    public int longestConsecutive(int[] nums) {
        int maxlen = 0;
        Set<Integer> set = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toSet());
        for (int num : set) {
            if (! set.contains(num-1)) {
                int newnum = num;
                while (set.contains(newnum)) {
                    newnum++;
                }
                maxlen = Math.max((newnum - num), maxlen);
            }
        }
        return maxlen;
    }
}
