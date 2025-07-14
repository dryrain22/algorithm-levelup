package dp;

class Solution2 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        for(int[] puddle : puddles) {
            dp[puddle[1]-1][puddle[0]-1] = -1;
        }

        boolean flag = false;
        for(int i = 0; i < m; i++) {
            if(dp[0][i] == -1 || flag) {
                flag = true;
                dp[0][i] = 0;
            }
            else dp[0][i] = 1;
        }

        flag = false;
        for(int i = 0; i < n; i++) {
            if(dp[i][0] == -1 || flag) {
                flag = true;
                dp[i][0] = 0;
            }
            else dp[i][0] = 1;
        }


        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {

                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;

            }
        }

        return dp[n-1][m-1];
    }
}
