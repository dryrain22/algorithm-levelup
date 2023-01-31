package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int max = 0;
        int min = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                //최고 층수
                max = Math.max(arr[i][j], max);
                min = Math.min(arr[i][j], min);
            }
        }

        int ans_time = Integer.MAX_VALUE;
        int ans_height = -1;
        for(int i = min; i <=max; i++) {
            int time = 0;
            int block = B;

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    int value = arr[j][k];
                    if(value == i) {
                        continue;
                    }
                    if(value > i) {
                        time += 2*(value-i);
                        block += value-i;
                    } else {
                        time += i-value;
                        block -= i-value;
                    }
                }
            }
            if(block < 0) continue;
            if(ans_time >= time) {
                ans_time = time;
                ans_height = i;
            }
        }
        System.out.println(ans_time + " " + ans_height);
    }
}
