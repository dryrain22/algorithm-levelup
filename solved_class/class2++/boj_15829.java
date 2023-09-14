package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//모듈러 정의(덧셈, 뺄셈, 곱셈에만) -> (A*B)%M = ((A%M) * (B%M)) %M
public class boj_15829 {
    static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int ch;
        long r = 1;
        long sum = 0;

        if(str.length() != L) System.exit(0);
        else {
            for(int i = 0; i < L; i++) {
                ch = str.charAt(i) - 'a' + 1;
                sum += (ch * r) % M;
                r = (31 * r) % M;
            }
        }
        System.out.println(sum % M);
    }
}
