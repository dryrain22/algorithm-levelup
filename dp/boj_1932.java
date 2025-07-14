package dp;

import java.util.*;
import java.io.*;

public class boj_1932 {
    static int[][] triangle;
    static int[][] dp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        triangle = new int[size][size];
        dp = new int[size][size];

        for(int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];

        if(size != 1) {
            dp[1][0] = triangle[1][0] + dp[0][0];
            dp[1][1] = triangle[1][1] + dp[0][0];

            for(int i = 2; i < size; i++) {
                dp[i][0] = triangle[i][0] + dp[i-1][0];
                dp[i][i] = triangle[i][i] + dp[i-1][i-1];

                for(int j = 1; j < i; j++) {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < size; i++) {
            max = Math.max(dp[size-1][i], max);
        }

        System.out.println(max);

    }
}
