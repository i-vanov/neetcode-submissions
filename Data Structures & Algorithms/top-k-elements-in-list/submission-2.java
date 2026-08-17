class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        // Build a frequency map that counts how many times each number appears
        for (int i : nums) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }
        // Create an empty min-heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // Push (number, frequency) into the heap
        // If the heap size becomes greater than k, pop once to remove the smallest freq
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            heap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        // Pop all elements from the heap and collect their numbers into the result list
        while (!heap.isEmpty()) {
            int[] element = heap.poll();
            res[index] = element[0];
            index++;
        }
        return res;
    }
}
