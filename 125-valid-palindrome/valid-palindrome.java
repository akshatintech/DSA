class Solution {
    public boolean isPalindrome(String s) {
        int l =0, r=s.length()-1;
        while(l<r){
            char lf = s.charAt(l);
            char rf = s.charAt(r);
            if(lf>='A' && lf<='Z') lf =(char)(lf+32);
            if(rf>='A' && rf<='Z') rf =(char)(rf+32);

            if('a'<=lf && lf <= 'z' || '0' <=lf && lf<= '9'){
                if('a'<=rf && rf <= 'z' || '0' <=rf && rf<= '9'){
                    if(lf!=rf) return false;
                    l++; r--;
                }else{
                    r--;
                }
            }else{
                l++;
            }

        }
        return true;
    }
}