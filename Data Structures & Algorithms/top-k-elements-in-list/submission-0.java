class Solution {
    class Frequency implements Comparable<Frequency> {
        public final int num;
        public int count = 0;
        Frequency(int n) {
            num = n;
        }
        public int compareTo(Frequency other) {
            return(other.count - count);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Frequency> map = new HashMap<>();
        for (int num : nums) {
            Frequency freq = map.getOrDefault(num, new Frequency(num));
            freq.count++;
            map.put(num, freq);
        }
        List<Frequency> freqList = new ArrayList<>(map.values());
        Collections.sort(freqList);
        int[] kfreq = new int[k];
        for (int i=0; i < k; i++) {
            kfreq[i] = freqList.get(i).num;
        }
        return kfreq;
    }
}
