class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Pair each car's position with its speed
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        // Sort the pairs in descending order by position
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for (int[] p : pair) {
            // Push the individual arrival time onto the stack
            stack.push((double) (target - p[0]) / p[1]);

            // If the current's car arrival time is smaller than the fleet ahead's arrival time, 
            // it will eventually join the fleet, so we remove it
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }
}
