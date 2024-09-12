class Solution {
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int[][] dp = new int[len][2002];
        return solve(pairs, 0, len, -1001, dp);
    }
    private int solve(int[][] pairs, int index, int len, int prev, int[][] dp)
    {
        if(index >= len)
            return 0;
        if(dp[index][prev + 1001] != 0)
            return dp[index][prev + 1001];
        int include = 0;
        if(pairs[index][0] > prev)
            include =  1 + solve(pairs, index + 1, len, pairs[index][1], dp);
        int exclude = solve(pairs, index + 1, len, prev, dp);
        return dp[index][prev + 1001] = Math.max(include, exclude);
    }
}