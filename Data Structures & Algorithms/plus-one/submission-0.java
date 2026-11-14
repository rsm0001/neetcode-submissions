class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i=0; (i < digits.length) && carry; i++) {
            int j = (digits.length - 1 - i);
            int sum = (digits[j] + (carry ? 1 : 0));
            digits[j] = ((sum > 9) ? (10 - sum) : sum);
            carry = (sum > 9);
        }
        if (! carry) {
            return digits;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i=0; i < digits.length; i++) {
            res[i+1] = digits[i];
        }
        return res;
    }
}
