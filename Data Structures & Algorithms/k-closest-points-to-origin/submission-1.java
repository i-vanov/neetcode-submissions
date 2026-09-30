class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Distance of a point from the origin is x^2 + y^2 and it is equivalent to comparing the square of it
        Queue<int[]> maxHeap = new PriorityQueue<>((a , b) -> ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])));

        int[][] res = new int[k][2];
        // Keep the k closest points in the maxHeap
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        // Fill the res array with the k points
        int heapSize = maxHeap.size();
        for (int i = 0; i < heapSize; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}