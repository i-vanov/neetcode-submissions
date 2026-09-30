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
            int slots = n + 1;
            while (slots > 0 && !maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                task--;

                if (task > 0) {
                    temp.add(task);
                }
                count++;
                slots--;
            }
            for (int task : temp) {
                maxHeap.offer(task);
            }
            if (!temp.isEmpty()) {
                count += slots;
            }
        }
        return count;
    }
}
