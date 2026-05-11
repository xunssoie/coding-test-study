package practice.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {

    private static final int TEST_CASES = 10;
    private static final int BOX_COUNT = 100;
    private static final int MAX_HEIGHT = 100;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TEST_CASES; tc++) {
            int dumpCount = Integer.parseInt(br.readLine());

            int[] heights = new int[MAX_HEIGHT + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int lowest = MAX_HEIGHT;
            int highest = 0;

            for (int i = 0; i < BOX_COUNT; i++) {
                int height = Integer.parseInt(st.nextToken());
                heights[height]++;

                if (height < lowest) lowest = height;
                if (height > highest) highest = height;
            }

            // 덤프 작업 반복: 가장 높은 박스를 한 칸 내리고, 가장 낮은 박스를 한 칸 올린다
            while (lowest < highest && dumpCount > 0) {
                heights[highest]--;
                heights[highest - 1]++;

                heights[lowest]--;
                heights[lowest + 1]++;

                dumpCount--;

                // 양 끝 버킷이 비었다면 포인터를 다음 유효 위치로 이동
                if (heights[lowest] == 0) lowest++;
                if (heights[highest] == 0) highest--;
            }

            sb.append('#').append(tc).append(' ').append(highest - lowest).append('\n');
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}