package LeetCode.Meadium.CarPooling;

public class CorrectSolution {

    public boolean carPooling(int[][] trips, int cap) {
        int[] A = new int[1001];
        for(int[] T : trips){
            A[T[1]] += T[0];
            A[T[2]] -= T[0];
        }
        int sum = 0;
        for(int i=0; i<1001; i++){
            sum += A[i];
            if(sum > cap)
                return false;
        }
        return true;
    }

}
