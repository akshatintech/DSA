class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
       Arrays.sort(nums);

       ArrayList<List<Integer>> list = new ArrayList<>();
       if(nums.length<4 || (long)nums[0] + nums[1] + nums[2] + nums[3] > target){
        return list;}

       for(int i = 0; i<n-3;i++){
        if(i>0 && nums[i] == nums[i-1]){
            continue;
        }

        for(int j = i+1;j<n;j++){
            if (j > i+1 && nums[j] == nums[j-1]){
                continue;
            }

        int k = j+1;
        int l = n-1;


        while (k < l) {
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }

            }
        }
        return list;
    
}
}



// Better Aproach : 

// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length;
        
//        Set<List<Integer>> set = new HashSet<>();
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     int fourth = target - (nums[i] + nums[k] + nums[j]);
//                     Set<Integer> hashset = new HashSet<>();
//                      List<Integer> list = new ArrayList<>();
//                     if (hashset.contains(fourth)) {                       
//                         list.add(nums[i]);
//                         list.add(nums[j]);
//                         list.add(nums[k]);
//                         list.add(fourth);
//                         Collections.sort(list);
//                         set.add(list);
//                     } else {
//                         hashset.add(nums[k]);
//                     }
//                 }
//             }
//         }
//         List<List<Integer>> ans = new ArrayList<>(set);
//         return ans;
//     }
// }





// Brute Force Approach :

// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         int n = nums.length;

//         Set<List<Integer>> set = new HashSet<>();

//         for(int i = 0;i<n;i++){
//             for(int j = i+1;j<n;j++){
//                 for(int k = j+1; k<n;k++){
//                     for(int l = k+1; l<n;l++){
//                         int sum = nums[i] + nums[j] + nums[l] + nums[k];
//                         List<Integer> list = new ArrayList<>();
//                         if(sum == target){
//                             list.add(nums[i]);
//                             list.add(nums[j]);
//                             list.add(nums[k]);
//                             list.add(nums[l]);
//                             Collections.sort(list);
//                             set.add(list);
//                         }
//                     }
//                 }
//             }
//         }
//         List<List<Integer>> ans = new ArrayList<>(set);
//         return ans;
//     }
// }