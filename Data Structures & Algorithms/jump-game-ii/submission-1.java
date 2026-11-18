class Solution {
    class Node {
        public int indx = -1;
        public int step = -1;
        public Node(int pos, int step) { indx = pos; this.step = step; }
    }

    public int jump(int[] nums) {
        int last = (nums.length - 1), minstep = nums.length;
        Set<Node> set = new HashSet<>();
        if (nums.length > 0) {
            boolean nochange = false;
            boolean[] processed = new boolean[nums.length];
            if (0 == last) { return 0; }
            set.add(new Node(0, 0));
            while (! nochange) {
                nochange = true;
                List<Node> list = new ArrayList<>(set);
                set.clear();
                for (Node node : list) {
                    int pos = node.indx;
                    for (int i=1; i <= nums[pos]; i++) {
                        if ((pos+i) >= nums.length) { break; }
                        if (last == (pos+i)) {
                            minstep = Math.min(minstep, (node.step + 1));
                            break;
                        }
                        if (! processed[pos+i]) {
                            nochange = false;
                            set.add(new Node((pos+i), (node.step + 1)));
                            processed[pos+i] = true;
                        }
                    }
                }
            }
        }
        return minstep;
    }
}
