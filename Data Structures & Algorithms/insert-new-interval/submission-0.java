class Solution {
    private boolean intersects(int[] intvl, int pt) {
        return((pt >= intvl[0]) && (pt <= intvl[1]));
    }

    private boolean intersects(int[] intvl1, int[] intvl2) {
        return(
            intersects(intvl1, intvl2[0]) ||
            intersects(intvl1, intvl2[1]) ||
            intersects(intvl2, intvl1[0]) ||
            intersects(intvl2, intvl1[1])
        );
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int last = (intervals.length - 1);

        if ((0 == intervals.length) || (newInterval[1] < intervals[0][0])) {
            int[][] res = new int[intervals.length+1][2];
            res[0][0] = newInterval[0];
            res[0][1] = newInterval[1];
            for (int i=0; i < intervals.length; i++) {
                res[i+1][0] = intervals[i][0];
                res[i+1][1] = intervals[i][1];
            }
            return res;
        }
        
        if (newInterval[0] > intervals[last][1]) {
            int[][] res = new int[intervals.length+1][2];
            for (int i=0; i < intervals.length; i++) {
                res[i][0] = intervals[i][0];
                res[i][1] = intervals[i][1];
            }
            res[intervals.length][0] = newInterval[0];
            res[intervals.length][1] = newInterval[1];
            return res;
        }

        int left = -1, right = intervals.length;
        for (int i=0; i < intervals.length; i++) {
            if (intersects(intervals[i], newInterval)) {
                left = i; break;
            }
        }
        for (int i=last; i >= 0; i--) {
            if (intersects(intervals[i], newInterval)) {
                right = i; break;
            }
        }

        if (-1 == left) {
            int[][] res = new int[intervals.length + 1][2];
            for (int i=0, j=0; i < intervals.length; i++, j++) {
                if (newInterval[1] < intervals[i][0]) {
                    res[j][0] = newInterval[0];
                    res[j][1] = newInterval[1];
                    j++;
                }
                res[j][0] = intervals[i][0];
                res[j][1] = intervals[i][1];
            }
            return res;
        }

        int reslen = (intervals.length - (right - left));
        int[][] res = new int[reslen][2];
        for (int i=0; i < left; i++) {
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }
        res[left][0] = Math.min(newInterval[0], intervals[left][0]);
        res[left][1] = Math.max(newInterval[1], intervals[right][1]);
        for (int i=(right+1), j=(left+1); i < intervals.length; i++, j++) {
            res[j][0] = intervals[i][0];
            res[j][1] = intervals[i][1];
        }

        return res;
    }
}
