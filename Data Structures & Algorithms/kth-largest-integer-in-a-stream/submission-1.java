class KthLargest {
    private final int heapSize;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.heapSize = k;
        if (nums != null) {
            for (int num : nums) { add(num); }
        }    
    }
    
    public int add(int val) {
        if (minHeap.size() < heapSize) {
            minHeap.offer(val);
        } else {
            if (val > minHeap.peek()) {
                minHeap.poll(); minHeap.offer(val);
            }
        }
        return minHeap.peek();
    }
}
