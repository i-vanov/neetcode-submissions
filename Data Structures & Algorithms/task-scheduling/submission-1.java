class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int count = 0;
        // Build a freq array of the tasks
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // The slots in one cycle are n + 1
            int slots = n + 1;
            while (slots > 0 && !maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                task--;
                // Store unfinished tasks in a temp list until cooldown
                if (task > 0) {
                    temp.add(task);
                }
                count++;
                slots--;
            }
            // Re-add the tasks again to the maxHeap with the new frequencies
            for (int task : temp) {
                maxHeap.offer(task);
            }
            // There are unused slots and unfinished tasks, so the remaining slots are idle
            if (!temp.isEmpty()) {
                count += slots;
            }
        }
        return count;
    }
}
