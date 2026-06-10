package practice.personal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 성적_정렬 {
    public static void main(String[] args) {

    }

    public static String[] solution(String[][] students){
        List<Score> scores = new ArrayList<>();

        for (String[] student : students) {
            scores.add(new Score(student[0], Integer.parseInt(student[1]), Integer.parseInt(student[2]), Integer.parseInt(student[3])));
        }

        scores.sort(
                Comparator.comparing(Score::getKorean, Comparator.reverseOrder())
                        .thenComparing(Score::getEnglish)
                        .thenComparing(Score::getMath, Comparator.reverseOrder())
        );

        String[] names = new String[scores.size()];
        for(int i = 0; i < scores.size(); i++){
            names[i] = scores.get(i).name;
        }

        return names;
    }

    static class Score{
        String name;
        int korean;
        int english;
        int math;

        public Score(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public int getKorean() {
            return korean;
        }

        public int getEnglish() {
            return english;
        }

        public int getMath() {
            return math;
        }
    }
}
