class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = (s.length() - 1);
        while (l < r) {
            char lc = s.charAt(l), rc = s.charAt(r);
            if (! Character.isLetterOrDigit(lc)) {
                l++; continue;
            }
            if (! Character.isLetterOrDigit(rc)) {
                r--; continue;
            }
            char lcu = Character.toUpperCase(lc);
            char rcu = Character.toUpperCase(rc);
            if (lcu != rcu) { return false; }
            l++; r--;
        }
        return true;
    }
}
