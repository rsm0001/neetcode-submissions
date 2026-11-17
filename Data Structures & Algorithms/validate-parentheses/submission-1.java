class Solution {
    private static final Map<Character, Integer> map = Map.of('(', 1, ')', -1, '[', 2, ']', -2, '{', 3, '}', -3);
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            int val = map.get(c);
            if (val > 0) { stack.push(val); }
            else {
                if (stack.isEmpty()) { return false; }
                if ((-1 * val) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
