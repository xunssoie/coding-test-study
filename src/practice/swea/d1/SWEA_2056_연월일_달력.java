package practice.swea.d1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class SWEA_2056_연월일_달력 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int T = Integer.parseInt(br.readLine());

        List<String> MONTH = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
        List<String> L_MONTH = Arrays.asList(
                "01", "03", "05", "07", "08", "10", "12"
        );
        List<String> S_MONTH = Arrays.asList(
                "04", "06", "09","11"
        );
        List<String> S_DAY = Arrays.asList(
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
        );
        List<String> L_DAY = Arrays.asList(
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
        );
        List<String> F_DAY = Arrays.asList(
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28"
        );

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            String input = br.readLine();

            String YYYY = input.substring(0, 4);
            String MM = input.substring(4, 6);

            if(!MONTH.contains(MM)){
                answer.append("#").append(t).append(" ").append(-1).append("\n");
                continue;
            }

            String DD = input.substring(6,8);

            if(L_MONTH.contains(MM)){
                if(L_DAY.contains(DD)){
                    answer.append("#").append(t).append(" ").append(YYYY).append("/").append(MM).append("/").append(DD).append("\n");
                }else{
                    answer.append("#").append(t).append(" ").append(-1).append("\n");
                }
            }else if(S_MONTH.contains(MM)) {
                if(S_DAY.contains(DD)){
                    answer.append("#").append(t).append(" ").append(YYYY).append("/").append(MM).append("/").append(DD).append("\n");
                }else{
                    answer.append("#").append(t).append(" ").append(-1).append("\n");
                }
            } else{
                if(F_DAY.contains(DD)){
                    answer.append("#").append(t).append(" ").append(YYYY).append("/").append(MM).append("/").append(DD).append("\n");
                }else{
                    answer.append("#").append(t).append(" ").append(-1).append("\n");
                }
            }
        }
        answer.setLength(answer.length()-1);
        System.out.print(answer);
    }
}
