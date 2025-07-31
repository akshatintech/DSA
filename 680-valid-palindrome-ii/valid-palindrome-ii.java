class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                // Try skipping either character
                return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }

        return true; // Already a palindrome
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
