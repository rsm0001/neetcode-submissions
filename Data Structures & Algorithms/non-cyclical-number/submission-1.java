class Solution {
    private int getSumOld(int n) {
        int sum = 0;
        while (n > 0) {
            int dig = (n % 10);
            n /= 10;
            sum += (dig * dig);
        }
        return(sum);
    }

    private int getSum(int n) {
        int sum = 0;
        for (char c : Integer.toString(n).toCharArray()) {
            int dig = (c - '0');
            sum += (dig * dig);
        }
        return(sum);
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = n;
        while (sum != 1) {
            sum = getSum(sum);
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
        }
        return true;
    }
}
