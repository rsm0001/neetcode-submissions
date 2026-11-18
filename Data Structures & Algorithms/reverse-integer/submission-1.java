class Solution {
    private static final int LIMIT = (Integer.MAX_VALUE / 10);
    public int reverse(int x) {
        boolean isneg = (x < 0);
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
            int dig = (x % 10);
            x /= 10;
            if ((res > LIMIT) || ((res == LIMIT) && (dig > 7))) {
                return 0;
            }
            res = ((res * 10) + dig);
        }
        return isneg ? -res : res;
    }
}
