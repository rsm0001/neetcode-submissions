class Solution {
    private int locateRow(int[][] matrix, int target) {
        int maxrow = (matrix.length - 1);
        int low = 0, high = maxrow;
        while (low < high) {
            int mid = (low + ((high - low) / 2));
            if (matrix[mid][0] <= target) {
                if (matrix[mid+1][0] > target) { return mid; }
                low = (mid + 1);
            } else { high = mid; }
        }
        return maxrow;
    }

    public boolean search(int[] nums, int target) {
        int low = 0, high = (nums.length - 1);
        while (low <= high) {
            int mid = (low + ((high - low) / 2));
            if (target == nums[mid]) { return true; }
            else if (target < nums[mid]) { high = (mid - 1); }
            else { low = (mid + 1); }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int maxrow = (matrix.length - 1), maxcol = (matrix[0].length - 1);
        if ((target >= matrix[0][0]) && (target <= matrix[maxrow][maxcol])) {
            int row = locateRow(matrix, target);
            return search(matrix[row], target);
        }
        return false;
    }
}
