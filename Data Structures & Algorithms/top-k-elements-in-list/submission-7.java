class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        // Build a frequency map
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        // bucket[freq] = numbers appearing freq times
        List<Integer>[] bucket = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        int[] res = new int[k];
        int index = 0;

        for (int freq = bucket.length - 1; freq > 0 && index < k; freq--) {
            if (bucket[freq] == null) {
                continue;
            }

            for (int num : bucket[freq]) {
                res[index] = num;
                index++;

                if (index == k) {
                    break;
                }
            }
        }
        return res;
    }
}
