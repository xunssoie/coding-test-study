package practice.swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1983_조교의_성적_매기기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Student> students = new ArrayList<>();
            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken());
                int f = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());

                students.add(new Student(i, m, f, a));
            }

            students.sort((a,b) -> Double.compare(b.t, a.t));

            for(int i = 0; i < N; i++){
                students.get(i).setRank((double)i * 100 / N);
            }

            Student target = students.get(0);
            for(int i = 0; i < N; i++){
                if(students.get(i).idx == K){
                    target = students.get(i);
                }
            }

            if(target.rank < 10.0){
                answer.append("#").append(t).append(" ").append("A+").append("\n");
            } else if (target.rank < 20.0) {
                answer.append("#").append(t).append(" ").append("A0").append("\n");
            } else if (target.rank < 30.0) {
                answer.append("#").append(t).append(" ").append("A-").append("\n");
            } else if (target.rank < 40.0) {
                answer.append("#").append(t).append(" ").append("B+").append("\n");
            } else if (target.rank < 50.0) {
                answer.append("#").append(t).append(" ").append("B0").append("\n");
            } else if (target.rank < 60.0) {
                answer.append("#").append(t).append(" ").append("B-").append("\n");
            } else if (target.rank < 70.0) {
                answer.append("#").append(t).append(" ").append("C+").append("\n");
            } else if (target.rank < 80.0) {
                answer.append("#").append(t).append(" ").append("C0").append("\n");
            } else if (target.rank < 90.0) {
                answer.append("#").append(t).append(" ").append("C-").append("\n");
            } else {
                answer.append("#").append(t).append(" ").append("D0").append("\n");
            }
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }

    static class Student{
        int idx;
        int m;
        int f;
        int a;
        double t;
        double rank;

        Student(
                int idx,
                int m,
                int f,
                int a
        ){
            this.idx = idx;
            this.m = m;
            this.f = f;
            this.a = a;
            this.t = (m * 0.35) + (f * 0.45) + (a * 0.2);
            this.rank = 0.0;
        }

        void setRank(double rank){
            this.rank = rank;
        }
    }
}
