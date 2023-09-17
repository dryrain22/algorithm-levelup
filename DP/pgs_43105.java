package DP;

import java.util.*;

class Solution {
    static int[][] dp;

    public int solution(int[][] triangle) {

        int size = triangle.length;
        dp = new int[size][size];

        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[1][0] + dp[0][0];
        dp[1][1] = triangle[1][1] + dp[0][0];

        for(int i = 2; i < size; i++) {
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            dp[i][i] = triangle[i][i] + dp[i-1][i-1];

            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
            }
        }

        int max = 0;
        for(int i = 0; i < size; i++) {
            max = Math.max(dp[size-1][i], max);
        }

        return max;

    }
}
