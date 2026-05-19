package practice.programmers;

import java.util.Arrays;

public class Programmers_체육복 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2,4}, new int[]{1,3,5}));
        System.out.println(solution(5, new int[]{2,4}, new int[]{3}));
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int[] uniforms =  new int[n+2];

        for(int i = 1; i<=n; i++){
            uniforms[i]++;
        }

        for (int l : lost) {
            uniforms[l]--;
        }

        for (int r : reserve) {
            uniforms[r]++;
        }

        for(int i = 0; i < lost.length; i++){
            int number = lost[i];

            if(uniforms[number] == 1){
                continue;
            }

            if(number == 1){
                if(uniforms[number+1] == 2){
                    uniforms[number]++;
                    uniforms[number+1]--;
                }
            }else if(number == n){
                if(uniforms[number-1] == 2){
                    uniforms[number]++;
                    uniforms[number-1]--;
                }
            }else{
                if(uniforms[number-1] == 2){
                    uniforms[number]++;
                    uniforms[number-1]--;
                }else if(uniforms[number+1] == 2){
                    uniforms[number]++;
                    uniforms[number+1]--;
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < uniforms.length; i++){
            if(uniforms[i] >= 1){
                answer++;
            }
        }

        return answer;
    }
}
