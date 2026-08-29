class Solution {
    public int trap(int[] height) {
        int amount = 0;
        int l = 0;
        int r = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (l < r) {
            // Process the left side if it is the limiting factor
            if (height[l] <= height[r]) {
                // If the current bar is higher than the tallest wall so far, then there can't be water on top of it
                if (height[l] >= leftMax) {
                    leftMax = height[l];
                } else {
                    // The current bar is smaller than the tallest left wall so far, so we add the possible amount of water on top of it
                    amount += leftMax - height[l];
                }
                // We've processed the position and move to the next one
                l++;
            }
            // Process the right side, if it is the limiting factor 
            else {
                if (height[r] >= rightMax) {
                    rightMax = height[r];
                } else {
                    amount += rightMax - height[r];
                }
                r--;
            }
        }
        return amount;
    }
}
