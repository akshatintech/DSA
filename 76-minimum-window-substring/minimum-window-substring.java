class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        if(t.length() > n){
            return "";
        }

        Map<Character , Integer> map = new HashMap<>();

        // We first Store the characters in the map
        for(char ch: t.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) +1);
        }

        int requiredCount = t.length();     //This is used to track if we still need to expand the window
        int i =0;
        int j= 0;

        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;


        while(j < n){       //Start with the window
            char ch= s.charAt(j);

            if(map.containsKey(ch) && map.get(ch) > 0){
                requiredCount--;            //If the map already contains the key and we find we reduce the count needed
            }

            map.put(ch , map.getOrDefault(ch , 0) -1);      //Reduce the count from map 

            while(requiredCount == 0){          //After we have found the window we start to shring
                int currWindowSize = j-i+1;
                if(minWindowSize > currWindowSize){
                    minWindowSize = currWindowSize;
                    start_i = i;                //We store the value of the i
                }

                char startChar = s.charAt(i);
                map.put(startChar , map.getOrDefault(startChar , 0) +1);

                if(map.containsKey(startChar) && map.get(startChar) > 0){       //THis is the new StartChar and we check if we need the first char
                    requiredCount++;
                }

                i++;
            }

            j++;
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i , start_i +minWindowSize );
    }
}