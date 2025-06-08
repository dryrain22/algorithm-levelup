package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num+1];

        // 1이거나 제곱수면 출력하고 종료
        if (num == 1 || (num % (int)Math.sqrt(num)) == 0) {
            System.out.println(1);
            System.exit(0);
        }

        dp[1] = 1;

        // 예외케이스 : 18
        // 9 + 9 , 16 + 1 + 1 같은 케이스 염두
        // 2부터 num까지 모든 경우의 수 탐색
        for (int i = 2; i <= num; i++) {
            dp[i] = i; // 1로만 표현핧 수 있는 갯수로 초기화
            // 탐색 시에, num까지의 모든 제곱수의 경우의 수 탐색
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[(i-j*j)] + 1);
            }
        }

        System.out.println(dp[num]);
    }
}
