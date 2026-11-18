class Solution {
    // 2's complement arithmetic
    public int getSum(int a, int b) {
        int res = 0, ibit = 1, carry = 0, sbit = 0;
        for (int i=0; i < 32; i++) {
            int abit = (a & 1), bbit = (b & 1);
            a >>>= 1; b >>>= 1;
            sbit = (abit ^ bbit ^ carry);
            if (1 == sbit) { res |= ibit; }
            carry = ((abit & bbit) | (abit & carry) | (bbit & carry));
            ibit <<= 1;
        }
        return res;
    }
}
