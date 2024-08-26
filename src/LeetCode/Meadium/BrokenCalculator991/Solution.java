package LeetCode.Meadium.BrokenCalculator991;

public class Solution {
    public static int brokenCalc(int startValue, int target) {
        int result = 0;
        while(target > startValue){
            if(target % 2 == 0){
                target /= 2;
            }
            else{
                target++;
            }
            result++;
        }
        return result + (startValue - target);
    }
    public static void main(String[] args) {
        System.out.println(brokenCalc(100, 300));
    }
}
