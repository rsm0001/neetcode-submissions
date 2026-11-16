class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = (numbers.length - 1);
        int indx1 = 0, indx2 = 0;
        while (l < r) {
            int sum = (numbers[l] + numbers[r]);
            if (sum == target) {
                indx1 = (l+1); indx2 = (r+1); break;
            } else if (sum < target) { l++; }
            else { r--; }
        }
        return new int[] { indx1, indx2 };
    }
}
