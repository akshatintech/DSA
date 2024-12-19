class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b)->{
            int i = a.indexOf(" ");
            int j = b.indexOf(" ");
            
            //if both are digit: sequence will be same, return 0;
            if(Character.isDigit(a.charAt(i+1)) && Character.isDigit(b.charAt(j+1))) return 0;

            //if first is digit & second is letter: swap is required, return 1;
            if(Character.isDigit(a.charAt(i+1))) return 1;

            //if first is letter & second is digit: return -1;
            if(Character.isDigit(b.charAt(j+1))) return -1;

            int val = a.substring(i+1).compareTo(b.substring(j+1));
            if(val != 0){
                return val;
            }

            return a.compareTo(b);
        });

        return logs;
    }
}