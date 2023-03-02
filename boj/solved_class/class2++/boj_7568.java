package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] xy = new int[N][2];


        for(int i = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xy[i][0] = x; xy[i][1] = y;
        }

        for(int i = 0; i < N; i++) {
            int rank = 1;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if(xy[i][0] < xy[j][0]  && xy[i][1] < xy[j][1]) rank++;
            }
            sb.append(rank + " ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
