package practice.personal;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,2,3}));
        System.out.println(solution(new int[]{2,2,1,1,1,2,2}));
    }

    public static int solution(int[] nums){
        int n = nums.length;

        int maxCount = n/2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if(value > maxCount)
                return key;
        }

        return -1;
    }
}
