class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count the frequencies of the nums
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i : nums) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }
        // 
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // Whenever heap size exceeds k, remove the least frequent element
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;

        while(!pq.isEmpty()) {
            int[] element = pq.poll();
            res[index] =  element[0];
            index++;
        }
        return res;
    }
}
