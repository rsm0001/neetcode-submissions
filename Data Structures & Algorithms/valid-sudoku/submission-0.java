class Solution {
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][] cubes = new boolean[9][9];

    private boolean isValid(int row, int col, int dim) {
        if (rows[row][dim]) { return false; }
        rows[row][dim] = true;
        if (cols[col][dim]) { return false; }
        cols[col][dim] = true;
        int cube = (((row / 3) * 3) + (col / 3));
        if (cubes[cube][dim]) { return false; }
        cubes[cube][dim] = true;
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int row=0; row < 9; row++) {
            for (int col=0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int dim = (board[row][col] - '0' - 1);
                    if (! isValid(row, col, dim)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
