package com.leetcode;

import com.sun.source.tree.Tree;

import java.sql.Array;
import java.util.*;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends


//User function Template for Java
class Solution {
    public static void main(String[] args) {

        int target = 9;
        System.out.println(2 / 3);
        int k = 5;


        String s1 = "weallloveyou";
        k =2;
        int[] nums = new int[]{1,2,3,1,2,3,1,2};
        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;
       generateParenthesis(3);



        ;


    }
    public static List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        backtrack(output , "" , 0 , 0 , n);
        return output;
    }

    public  static void backtrack(List<String> output_arr , String current_string , int open , int close , int max){
        if(current_string.length() == max*2){
            output_arr.add(current_string);
        }

        if(open < max){
            backtrack(output_arr , current_string + "(" , open+1 , close , max);
        }

        if(close < open){
            backtrack(output_arr , current_string + ")" , open , close+1 , max);
        }
    }


}









