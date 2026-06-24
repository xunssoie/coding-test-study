package practice.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Programmers_보석_쇼핑 {
    public static void main(String[] args) {
        System.out.println("depth= " + Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.println("depth= " + Arrays.toString(solution(new String[]{"XYZ", "XYZ", "XYZ"})));
    }

    public static int[] solution(String[] gems) {
        Set<String> gemTypeSet = new HashSet<>(Arrays.asList(gems));

        Map<String, Integer> gemCountMap = new HashMap<>();
        for (String gem : gemTypeSet) {
            gemCountMap.put(gem, 0);
        }

        int left = 0;
        int right = -1;

        int answerLeft = 0;
        int answerRight = gems.length - 1;

        while (true) {
            if (!containsAllGems(gemCountMap, gemTypeSet)) {
                right++;

                if (right == gems.length)
                    break;

                gemCountMap.put(gems[right], gemCountMap.get(gems[right]) + 1);
            } else {
                if (right - left < answerRight - answerLeft) {
                    answerLeft = left;
                    answerRight = right;
                }
                gemCountMap.put(gems[left], gemCountMap.get(gems[left]) - 1);
                left++;

                if (left > right)
                    break;
            }
        }
        return new int[]{answerLeft+1, answerRight+1};
    }

    private static boolean containsAllGems(Map<String, Integer> gemCountMap, Set<String> gemSet) {
        for (String gem : gemSet) {
            if(gemCountMap.get(gem) == 0){
                return false;
            }
        }
        return true;
    }
}
