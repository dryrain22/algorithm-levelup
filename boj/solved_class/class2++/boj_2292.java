package solved_class.solved2_plus_plus;

import java.io.*;

/**
 * 2 ~7  6각형 방:2개
 * 8~19 12각형 방:3개
 * 20~37 18각형 방:4개
 * 38~61 24각형 방:5개
 */
public class boj_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if(N==1) {
            bw.write(String.valueOf(1));
            bw.flush();
            bw.close();
        }
        int last_num = 1;
        for(int i = 1; i < N; i++ ) {
            if(6*i+last_num < N) {
                last_num += 6*i;
            } else {
                bw.write(String.valueOf(i+1));
                bw.flush();
                bw.close();
                break;
            }
        }

        br.close();
    }
}
