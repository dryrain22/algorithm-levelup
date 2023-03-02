package solved_class.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * zero[n] = zero[n-1] + zero[n-2]
 * one[n] = one[n-1] + one[n-2]
 */


public class boj_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] zero = new int[41];
        int[] one = new int[41];
        //초기값 세팅
        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;


        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 2; j <= num; j++) {
                zero[j] = zero[j - 1] + zero[j - 2];
                one[j] = one[j - 1] + one[j - 2];
            }
            System.out.println(zero[num] + " " + one[num]);
        }
    }
}
