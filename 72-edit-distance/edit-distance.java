class Solution {
    public int m;
    public int n;
    public int[][] memo;  // Memoization table

    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        memo = new int[m][n];  // Initialize memo table

        // Fill memo table with -1 (to indicate uncalculated states)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return solve(word1, word2, 0, 0);
    }

    public int solve(String s1, String s2, int i, int j) {
        // Base case: if we reach the end of either string
        if (i == m) {
            return n - j; // Insert remaining characters from s2
        }
        if (j == n) {
            return m - i; // Delete remaining characters from s1
        }

        // If already computed, return the cached value
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // If characters are equal, no operation needed, move to the next pair
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = solve(s1, s2, i + 1, j + 1);
        } else {
            // Calculate costs of insert, delete, and replace operations
            int insertC = 1 + solve(s1, s2, i, j + 1);   // Insert
            int deleteC = 1 + solve(s1, s2, i + 1, j);   // Delete
            int replaceC = 1 + solve(s1, s2, i + 1, j + 1); // Replace

            // Take the minimum of the three possible operations
            memo[i][j] = Math.min(insertC, Math.min(deleteC, replaceC));
        }

        return memo[i][j];  // Return the computed value
    }
}
