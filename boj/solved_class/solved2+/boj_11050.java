package solved_class.solved2_essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int multiple = 1;
        int divide = 1;

        for(int i = N; i > N-K; i--) {
            multiple *= i;
        }
        for(int i = K; i >= 1; i--) {
            divide *= i;
        }
        System.out.println(multiple/divide);
    }
}
