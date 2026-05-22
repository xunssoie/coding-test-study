package practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4013_특이한_자석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for(int t = 1; t <= T; t++){
            int K = Integer.parseInt(br.readLine());

            int[][] blades = new int[4][8];
            for(int i = 0; i < 4; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j = 0; j < 8; j ++){
                    blades[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < K; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int targetMagnet = Integer.parseInt(st.nextToken()) - 1;
                boolean reverse = Integer.parseInt(st.nextToken()) == -1;


                boolean b1 = blades[0][2] != blades[1][6];
                boolean b2 = blades[1][2] != blades[2][6];
                boolean b3 = blades[2][2] != blades[3][6];

                if(targetMagnet == 0){
                    rotate(blades[0], reverse);
                    if(b1){
                        rotate(blades[1], !reverse);
                        if(b2){
                            rotate(blades[2], reverse);
                            if (b3){
                                rotate(blades[3], !reverse);
                            }
                        }
                    }
                }else if(targetMagnet == 1){
                    rotate(blades[1], reverse);
                    if(b1){
                        rotate(blades[0], !reverse);
                    }
                    if(b2){
                        rotate(blades[2], !reverse);
                        if(b3){
                            rotate(blades[3], reverse);
                        }
                    }
                }else if(targetMagnet == 2){
                    rotate(blades[2], reverse);
                    if(b2){
                        rotate(blades[1], !reverse);
                        if(b1){
                            rotate(blades[0], reverse);
                        }
                    }
                    if(b3){
                        rotate(blades[3], !reverse);
                    }
                }else{
                    rotate(blades[3], reverse);
                    if(b3){
                        rotate(blades[2], !reverse);
                        if(b2){
                            rotate(blades[1], reverse);
                            if(b1){
                                rotate(blades[0], !reverse);
                            }
                        }
                    }
                }
            }
            int score = checkTotalScore(blades);
            answer.append("#").append(t).append(" ").append(score).append("\n").append("\n");
        }
        answer.setLength(answer.length() - 1);
        System.out.print(answer);
    }

    private static int checkTotalScore(int[][] blades) {
        int s1 = blades[0][0] == 0 ? 0 : 1;
        int s2 = blades[1][0] == 0 ? 0 : 2;
        int s3 = blades[2][0] == 0 ? 0 : 4;
        int s4 = blades[3][0] == 0 ? 0 : 8;

        return s1 + s2 + s3 + s4;
    }

    private static void rotate(int[] magnet, boolean reverse){
        int[] newMagnet = new int[magnet.length];

        if(reverse){
            for(int i = 0; i < magnet.length; i++){
                if(i == 7){
                    newMagnet[i] = magnet[0];
                    continue;
                }
                newMagnet[i] = magnet[i+1];
            }
            System.arraycopy(newMagnet, 0, magnet, 0, magnet.length);
        }else{
            for(int i = 0; i < magnet.length; i++){
                if(i == 0){
                    newMagnet[i] = magnet[7];
                    continue;
                }
                newMagnet[i] = magnet[i-1];
            }
            System.arraycopy(newMagnet, 0, magnet, 0, magnet.length);
        }
    }
}
