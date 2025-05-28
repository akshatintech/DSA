class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        int value = 0;
        String ans = "";
        for(String s : arr){
            value = 0;
            if(map.containsKey(s)){
                value = map.get(s);
            }
            map.put(s , value+1);
        }
         int count = 0;
        for (String s : arr) {
            if (map.get(s) == 1) {
                count++;
                if (count == k) {
                    return s;
                }
            }
        }
        return ans;
    }
}