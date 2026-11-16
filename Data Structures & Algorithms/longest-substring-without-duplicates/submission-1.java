class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (0 == s.length()) { return 0; }
        int maxlen = 1, l = 0, r = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        while (r < s.length()) {
            char rc = s.charAt(r);
            if (map.containsKey(rc)) {
                if (map.get(rc) < l) {
                    maxlen = Math.max(maxlen, (r - l + 1));
                } else {
                    l = (map.get(rc) + 1);
                }
            } else {
                maxlen = Math.max(maxlen, (r - l + 1));
            }
            map.put(rc, r++);
        }
        return maxlen;
    }
}
