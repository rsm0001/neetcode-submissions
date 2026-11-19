class Solution {
    // my solution was simplified
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length < 1) { return gas.length; }
        int sum = 0, total = 0, station = 0;
        for (int i=0; i < gas.length; i++) {
            int diff = (gas[i] - cost[i]);
            total += diff; sum += diff;
            if (sum < 0) { station = (i+1); sum = 0; }
        }
        return (total < 0) ? -1 : station;
    }
}
