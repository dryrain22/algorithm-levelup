import java.io.*;
import java.util.*;

public class boj11501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N; int max;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            int answer = 0;
            int[] prices = new int[N];

            for (int j = 0; j < N; j++) {
                prices[j] = Integer.parseInt(st.nextToken());
            }

            max = prices[N - 1];

            // 뒤에서부터 탐색
            for (int j = N - 2; j >= 0; j--) {
                // 현재 금액이 max 금액보다 크면 업데이트
                if (max < prices[j]) {
                    max = prices[j];
                    continue;
                }
                answer += max - prices[j];
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }
}
