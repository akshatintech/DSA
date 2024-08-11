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
        String s = "ADOBECODEBANC";
        String t = "ABC";

        minWindow(s,t);




        ;


    }
    public static String minWindow(String s, String t) {
        int left = 0;
        int right= 0;
        int len = s.length();
        String ans = s.substring(right);
        while(right < len){
            ans = s.substring(left , right);
            for(int i = 0 ;i < t.length(); i++){
                char ch =   t.charAt(i);
                String str = String.valueOf(ch);
                if(!ans.contains(str)){
                    right++;
                    break;
                }
                if(i == t.length()-1){
                    left++;
                }
            }
        }
        return "";
    }





}









