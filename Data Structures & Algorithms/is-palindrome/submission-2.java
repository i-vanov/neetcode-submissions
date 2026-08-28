class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // Skip non-alphanumeric chars from the left
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                // Skip non-alphanumeric chars from the right
                j--;
            } else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                // If chars are equal, update the pointers
                i++;
                j--;
            } else {
                // If chars are not equal, the string is not a palindrome
                return false;
            }
        }
        return true;
    }
}
