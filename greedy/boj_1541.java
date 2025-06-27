package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");

        int ans = Integer.MAX_VALUE;

        while(st.hasMoreTokens()) {
            int sum = 0;

            StringTokenizer str = new StringTokenizer(st.nextToken(),"+");

            while(str.hasMoreTokens()) {
                sum += Integer.parseInt(str.nextToken());
            }

            // 첫번째 값은 더해줌
            if(ans == Integer.MAX_VALUE)
                ans = sum;
            else
                ans -= sum;
        }

        System.out.println(ans);
    }
}
