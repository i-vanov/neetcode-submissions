class Solution {
    public int findKthLargest(int[] nums, int k) {
        /**
        * Use minHeap to keep the k largest elements and
        * throw away new smaller elements
        *
        * IN GENERAL:
        * 
        * k smallest -> Max Heap (throw away bigger)
        * k largest -> Min Heap (throw away smaller)
        **/
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
