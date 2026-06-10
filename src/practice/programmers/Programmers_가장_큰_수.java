package practice.programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_가장_큰_수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
    }

    public static String solution(int[] numbers) {
        List<String> numberList = new ArrayList<>();

        for (int number : numbers) {
            numberList.add(String.valueOf(number));
        }

        numberList.sort((a,b) -> (b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();
        for (String s : numberList) {
            sb.append(s);
        }

        String answer = sb.toString();

        if(answer.startsWith("0"))
            return "0";

        return answer;
    }
}
