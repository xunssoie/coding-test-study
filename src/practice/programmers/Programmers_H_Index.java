package practice.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Programmers_H_Index {
    public static void main(String[] args) {
        // 공식 예제: 정답 3
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));   // 기대값 3

        // 함께 트레이스한 케이스: 정답 3
        System.out.println(solution(new int[]{7, 4, 4, 2, 1, 0})); // 기대값 3

        // 중복 전부 동일: 정답 5
        System.out.println(solution(new int[]{5, 5, 5, 5, 5}));    // 기대값 5

        // 단일 원소, 인용 0회: 정답 0
        System.out.println(solution(new int[]{0}));               // 기대값 0

        // 단일 원소, 큰 값: 정답 1
        System.out.println(solution(new int[]{100}));             // 기대값 1
    }

    public static int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        for (int citation : citations) {
            list.add(citation);
        }

        list.sort(Comparator.reverseOrder());

        int answer = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) >= i+1){
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }
}
