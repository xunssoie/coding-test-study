package practice.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1253_좋다 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int count = 0;
        for(int i = 0; i < N; i++){
            if(isGood(array, i))
                count++;
        }

        System.out.print(count);
    }

    private static boolean isGood(int[] array, int targetIdx){
        int target = array[targetIdx];

        int left = 0;
        int right = array.length - 1;

        while(left < right){
            if(left == targetIdx){
                left++;
                continue;
            }

            if(right == targetIdx){
                right--;
                continue;
            }

            int sum = array[left] + array[right];

            if(sum == target){
                return true;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}
