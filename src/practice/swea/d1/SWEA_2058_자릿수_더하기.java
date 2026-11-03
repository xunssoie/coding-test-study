package practice.swea.d1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_2058_자릿수_더하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int sum = 0;
        for(int i = 0; i < input.length(); i++){
            sum += Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        System.out.print(sum);
    }
}
