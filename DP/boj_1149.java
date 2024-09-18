package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1149 {
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        dp = new int[n][3];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        // dp의 첫번째 값은 1 번째 집 색상 비용으로 초기화
        dp[0][0] = cost[0][0]; dp[0][1] = cost[0][1]; dp[0][2] = cost[0][2];

        System.out.println(Math.min(Math.min(paint(n-1, 0), paint(n-1, 1)), paint(n-1, 2)));
    }
    /*
    color: 0 -> RED
    color: 1 -> GREEN
    color: 2 -> BLUE
    */
    static int paint(int idx, int color) {
        // 방문하지 않았다면
        if(dp[idx][color] == 0) {

            // 현재 칠한 color색에 따라서 이전 집의 해당 색을 제외한 다른 색을 재귀호출 후 최소값 + 현재 칠한 색 비용 dp에 반영
            if(color == 0) {
                dp[idx][color] = Math.min(paint(idx-1, 1), paint(idx-1, 2)) + cost[idx][color];
            } else if(color == 1) {
                dp[idx][color] = Math.min(paint(idx-1, 0), paint(idx-1, 2)) + cost[idx][color];
            } else {
                dp[idx][color] = Math.min(paint(idx-1, 0), paint(idx-1, 1)) + cost[idx][color];
            }
        }

        return dp[idx][color];
    }
}
