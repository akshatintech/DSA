class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for(int i = 0; i< n ;i++){
            int current = 0;
            for(int j = i; j < n ;j++){
                current += nums[j];
                pq.offer(current);
            }
        }

        int sum = 0;
        final int mod = 1000000007;
        int index = 0;
        while(!pq.isEmpty()){
            if(index >= right) break;
            if(index >= (left -1)) sum = (sum + pq.peek())% mod;
            pq.poll();
            index++;
        }

        return sum;
    }
}