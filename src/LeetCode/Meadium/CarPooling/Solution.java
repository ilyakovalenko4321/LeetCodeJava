package LeetCode.Meadium.CarPooling;

import java.util.TreeMap;

public class Solution {

    public static boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> changes = new TreeMap<>();

        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            changes.put(start, changes.getOrDefault(start, 0) + passengers);
            changes.put(end, changes.getOrDefault(end, 0) - passengers);
        }

        int currentPassengers = 0;
        for (int change : changes.values()) {
            currentPassengers += change;
            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[][] trips = new int[][]{
                {2, 1, 5},
                {3, 3, 7}
        };

        int capacity = 5;

        System.out.println(carPooling(trips, capacity));
    }
}
