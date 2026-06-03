package practice.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_의상 {
    public static void main(String[] args) {
        String[][] t1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solution(t1)); // 5
        String[][] t2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };
        System.out.println(solution(t2)); // 3
    }

    public static int solution(String[][] clothes){
        // key = 카테고리, value = 옷 명칭
        Map<String, List<String>> categoryToNames = new HashMap<>();

        for (String[] item : clothes) {
            String category = item[1];
            String name = item[0];

            List<String> names = categoryToNames.getOrDefault(category, new ArrayList<>());
            names.add(name);

            categoryToNames.put(category, names);
        }

        int combinations = 1;
        for (Map.Entry<String, List<String>> entry : categoryToNames.entrySet()) {
            combinations = combinations * (entry.getValue().size() + 1);
        }

        return combinations - 1;
    }
}
