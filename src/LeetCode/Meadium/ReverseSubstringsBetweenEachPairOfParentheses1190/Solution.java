package LeetCode.Meadium.ReverseSubstringsBetweenEachPairOfParentheses1190;

import java.util.*;

public class Solution {

    public static String reverseParentheses(String s) {

        Deque<Integer> indStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for(char character: s.toCharArray()){
            if (character == '(') {
                indStack.push(res.length());
            } else if (character==')') {
                int startInd = indStack.pop();
                String reversed = new StringBuilder(res.substring(startInd)).reverse().toString();
                res.replace(startInd, res.length(), reversed);
            }else{
                res.append(character);
            }
        }
       return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }
}
