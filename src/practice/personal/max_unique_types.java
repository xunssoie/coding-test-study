package practice.personal;

import java.util.HashSet;
import java.util.Set;

public class max_unique_types {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
        System.out.println(solution(new int[]{3,3,3,2,2,2}));
    }

    public static int solution(int[] nums){
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), nums.length/2);
    }
}
