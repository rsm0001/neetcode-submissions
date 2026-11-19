class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length < 1) { return gas.length; }
        int[] sumcost = new int[gas.length];
        int sum = 0;
        for (int i=0; i < gas.length; i++) {
            sumcost[i] = (gas[i] - cost[i]);
            sum += sumcost[i];
        }
        if (sum < 0) { return -1; }
        int station = -1; sum = 0;
        for (int i=0; i < gas.length; i++) {
            sum += sumcost[i];
            if (sum < 0) { station = -1; sum = 0; }
            else { if (station < 0) { station = i; } }
        }
        return station;
    }
}
