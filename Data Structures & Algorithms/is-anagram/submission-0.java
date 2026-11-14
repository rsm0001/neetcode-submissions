class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
            int[] counts = new int[26];
            for (char c : s.toCharArray()) {
                counts[c-'a']++;
            }
            for (char c : t.toCharArray()) {
                counts[c-'a']--;
                if (counts[c-'a'] < 0) {
                    return false;
                } 
            }
            for (int cnt : counts) {
                if (cnt != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
