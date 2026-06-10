package practice.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_기능개발 {
    public static void main(String[] args) {
        // 예제 1 → [2, 1]
        System.out.println("answer = " + Arrays.toString(
                solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        // 예제 2 → [1, 3, 2]
        System.out.println("answer = " + Arrays.toString(
                solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int rest = 100 - progresses[i];
            days[i] = (int) Math.ceil((double) rest / speeds[i]);
        }

        List<Integer> deployments = new ArrayList<>();
        int leadDay = days[0];
        int count = 1;
        for (int i = 1; i < days.length; i++) {
            if (days[i] <= leadDay) {
                count++;
            } else {
                deployments.add(count);
                leadDay = days[i];
                count = 1;
            }
        }
        deployments.add(count);

        int[] result = new int[deployments.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = deployments.get(i);
        }
        return result;
    }
}