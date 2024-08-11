package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(3);
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
