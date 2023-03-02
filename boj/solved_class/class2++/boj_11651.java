package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] xy = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xy, (o1, o2) -> {
            if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            else return Integer.compare(o1[1], o2[1]);
        });

        for(int[] arr : xy) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
}
