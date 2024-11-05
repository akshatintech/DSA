class Solution {

    private int maxTime = Integer.MIN_VALUE;

    private void DFS(Map<Integer , List<Integer>> adj , int[] informTime , int curr_employee , int currTime){
        maxTime = Math.max(currTime , maxTime);

        if(adj.containsKey(curr_employee)){
            for(int v : adj.get(curr_employee)){
                DFS(adj , informTime , v , currTime + informTime[curr_employee]);
            }
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer , List<Integer>> adj = new HashMap<>();

        for(int i = 0; i< manager.length ;i++){
            int child = i;
            int manager_i = manager[i];

            if(manager[i] != -1){
               adj.computeIfAbsent(manager_i, k -> new ArrayList<>()).add(child);
            }
        }
        DFS(adj , informTime ,headID , 0);
        return maxTime;

    }
}