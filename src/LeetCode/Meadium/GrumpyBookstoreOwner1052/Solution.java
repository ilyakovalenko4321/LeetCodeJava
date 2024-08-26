package LeetCode.Meadium.GrumpyBookstoreOwner1052;

import java.util.Arrays;

public class Solution {

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        //Creating an array with zeros on coords that have zeros in grumpy. Counting Start sum
        int result = 0;
        int[] unsatisfiedCustomers = new int[customers.length];
        for (int i = 0; i < customers.length; i++) {

            if (grumpy[i] == 0) {
                result += customers[i];
                unsatisfiedCustomers[i] = 0;
            } else {
                unsatisfiedCustomers[i] = customers[i];
            }
        }

        //Searching for biggest benefits
        int biggestCustomersBenefit = 0;
        for (int i = 0; i <= unsatisfiedCustomers.length - minutes; i++){
            int benefitInTheMoment = Arrays.stream(unsatisfiedCustomers, i, Math.min(i + minutes, unsatisfiedCustomers.length)).sum();
            biggestCustomersBenefit = Math.max(biggestCustomersBenefit, benefitInTheMoment);
        }

        return result + biggestCustomersBenefit;
    }

    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

}
