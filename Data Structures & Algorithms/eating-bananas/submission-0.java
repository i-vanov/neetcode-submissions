class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l <= r) {
            int m = l + (r - l) / 2;
            int hours = 0;
            for (int pile : piles) {
                // Use Math.ceil for positive integers
                hours += (pile + m - 1) / m;
            }
            if (hours > h) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        // When we exit the while loop, l is the smallest working speed
        return l;
    }
}
