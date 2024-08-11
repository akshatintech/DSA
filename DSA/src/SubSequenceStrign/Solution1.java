package SubSequenceStrign;


import java.util.*;

public class Solution1 {
    public static void main(String[] args) {


        int[] arr = new int[]{84,69,9,513,82,69,42,336,95};
        int target = 840;
        int index = 0;
        String str = "abc";
        char ch= 'a';
        String ans = "";
        int[] start = new int[] {1,3,0,5,8,5};
        int[] end = new int[] {2,4,6,7,9,9};
        permutations("", str);
        System.out.println(321);


    }


    public static void permutations(String p , String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return ;
        }

        char ch = up.charAt(0);

        for(int i = 0;i<= p.length();i++) {
            String first = p.substring(0,i);
            String second = p.substring(i);
            permutations(first+ch+second, up.substring(1));
        }
    }














}



