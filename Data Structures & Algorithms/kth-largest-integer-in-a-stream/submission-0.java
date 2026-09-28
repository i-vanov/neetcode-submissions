class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }    
    }
    
    public int add(int val) {
        minHeap.offer(val);
        // Keep adding elements to the minHeap until its size > k
        if (minHeap.size() > k) {
            // remove the k + 1th element
            minHeap.poll();
        }
        // return the k-th largest element
        return minHeap.peek();
    }
}
