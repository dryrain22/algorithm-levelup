package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//1 5 15
//1 4 10
//1 3 6
//1 2 3
/**
 * a층의 b호 거주조건: a-1층의 1~b호까지의 사람수의 합 데려와 살아야함
 * 0층부터 있고, i호에는 i명이 산다.
 * 비어있는 집 X , k층에 n호에는 몇명 살고있는지?
 */
public class boj_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(recursive(k,n));
        }
    }

     private static int recursive(int k, int n) {
        if(n == 1) return 1;
        else if(k == 0) return n;
        else return recursive(k, n-1) + recursive(k-1, n);
    }
}
