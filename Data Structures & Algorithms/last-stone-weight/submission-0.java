class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first - second == 0) {
                continue;
            } else if (first - second > 0) {
                maxHeap.offer(first - second);
            }
        }
        return maxHeap.peek() != null ? maxHeap.poll() : 0;
    }
}
