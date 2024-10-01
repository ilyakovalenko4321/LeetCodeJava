package LeetCode.Easy.SplitStringIntoBalancedString1221;

public class Solution {
    public static int balancedStringSplit(String s) {
        int R = 0;
        int L = 0;
        int result = 0;
        for(char character : s.toCharArray()){
            if(character == 'R'){
                R++;
            }
            else{
                L++;
            }
            if(R==L){
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }
}
