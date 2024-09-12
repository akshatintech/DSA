class Solution {
    public int findLongestChain(int[][] ps) {
        Arrays.sort(ps, (a, b) -> a[0]-b[0] );

        int n = ps.length, nxt[] = new int[n+1];
    
        for(int ind=n-1; ind>=0; ind--){
            for(int prevInd = ind; prevInd>=0; prevInd--){
                int ans = 0, prevVal = ( prevInd == 0 ? Integer.MIN_VALUE : ps[prevInd-1][1] );

                if( prevVal < ps[ind][0] ) ans = 1 + nxt[ind+1];
                ans = Math.max(ans, nxt[prevInd] );

                nxt[prevInd] = ans;
            }
        }
        return nxt[0];
    }
}