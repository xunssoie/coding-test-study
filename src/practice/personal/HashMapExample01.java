package practice.personal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class HashMapExample01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int numberCount = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < numberCount; i++) {
                int number = Integer.parseInt(st.nextToken());
                frequencyMap.merge(number, 1, Integer::sum);
            }

            int mostFrequentNumber = Integer.MAX_VALUE;
            int maxFrequency = -1;
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                int number = entry.getKey();
                int frequency = entry.getValue();

                if (frequency > maxFrequency) {
                    maxFrequency = frequency;
                    mostFrequentNumber = number;
                } else if (frequency == maxFrequency) {
                    mostFrequentNumber = Math.min(mostFrequentNumber, number);
                }
            }
            result.append("#").append(t).append(" ").append(mostFrequentNumber).append("\n");
        }
        result.setLength(result.length() - 1);
        System.out.print(result);
    }
}