package LeetCode.Easy.FindCityJudge997;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    private static Map<Integer, Set<Integer>> humanWhomTrust_peoplesWhoTrust;

    public static int findJudge(int n, int[][] trust) {
        humanWhomTrust_peoplesWhoTrust = new HashMap<>();
        for(int[] human: trust){
            int humanWhoTrust = human[0];
            int humanToWhoTrust = human[1];
            if(humanWhomTrust_peoplesWhoTrust.containsKey(humanToWhoTrust)){
                Set<Integer> setOfTrusted = humanWhomTrust_peoplesWhoTrust.get(humanToWhoTrust);
                setOfTrusted.add(humanWhoTrust);
                humanWhomTrust_peoplesWhoTrust.put(humanToWhoTrust, setOfTrusted);
            }else{
                Set<Integer> newSet = new HashSet<>();
                newSet.add(humanWhoTrust);
                humanWhomTrust_peoplesWhoTrust.put(humanToWhoTrust, newSet);
            }
        }

        int judge = -1;
        int maxTrustSize = 0;

        for (Map.Entry<Integer, Set<Integer>> entry : humanWhomTrust_peoplesWhoTrust.entrySet()) {
            int humanToWhoTrust = entry.getKey();
            int trustSize = entry.getValue().size();

            if (trustSize > maxTrustSize) {
                maxTrustSize = trustSize;
                judge = humanToWhoTrust;
            }
        }

        for (int[] i: trust){
            int h = i[0];
            if(h == judge){
                judge = -1;
                break;
            }
        }
        if(n == 1){
            return 1;
        }
        // Возвращаем "судью" только если количество людей, доверяющих ему, равно n-1
        return maxTrustSize == n - 1 ? judge : -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }
}
