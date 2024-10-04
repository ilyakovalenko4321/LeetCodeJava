package LeetCode.Easy.FindNarrowsPoint1779;

public class Solution {

    public static int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = -1;
        int number = -1;
        for(int iterator = 0; iterator < points.length; iterator ++){
            int[] point = points[iterator];
            int newPointX = point[0];
            int newPointY = point[1];
            if((x == newPointX) || (y == newPointY)) {
                int manhattanDistance = Math.abs(x - newPointX) + Math.abs(y - newPointY);
                if(minDistance == -1){
                    minDistance = manhattanDistance;
                    number = iterator;
                } else if (minDistance>manhattanDistance) {
                    minDistance = manhattanDistance;
                    number = iterator;
                }
            }
        }
        return number;
    }

    public static void main(String[] args){
        int[][] array = {
                {1, 1},
                {6, 2},
                {1, 5},
                {3, 1}
        };
        System.out.println(nearestValidPoint(5, 1, array));
    }
}
