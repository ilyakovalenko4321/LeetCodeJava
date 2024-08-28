package LeetCode.Meadium.ReverseSubstringsBetweenEachPairOfParentheses1190;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CorrectSolution {

    static int[] index;
    static char[] chars;
    static int N;
    public static String reverseParentheses(String s) {
        index = new int[1];
        chars = s.toCharArray();
        N = chars.length;

        return helper(new StringBuilder());
    }

    static String helper(StringBuilder builder){
        if(index[0] == N){
            return builder.toString();
        }

        while(index[0] < N){
            char ch = chars[index[0]];
            if(ch == '('){
                index[0]++;
                String temp = helper(new StringBuilder());
                builder.append(temp);
            } else if(ch == ')'){
                return builder.reverse().toString();
            } else {
                builder.append(ch);
            }
            index[0]++;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }
}


