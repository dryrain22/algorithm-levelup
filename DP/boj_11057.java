package DP;


import java.io.*;
import java.util.Arrays;

public class boj_11057 {
    /**
     * 오르막 수
     *         0 1 2 3 4 5 6 7 8 9(오르막 수의 마지막 숫자)
     *    N=1  1 1 1 1 1 1 1 1 1 1 = 10
     *    N=2  1 2 3  4  5  6  7  8  9  10 = 55
     *    N=3  1 3 6 10 15 21 28 36 45 55 = 220
     *
     *    arr[i][j] = arr[i-1][j] + arr[i][j-1]
    **/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] resultArr = new int[N][10];
        Arrays.fill(resultArr[0], 1);

        for(int i = 1; i < N; i++) {
            resultArr[i][0] = 1;

            for(int j = 1; j < 10; j++) {
                resultArr[i][j] = resultArr[i-1][j] + resultArr[i][j-1];
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println(Arrays.stream(resultArr[N-1]).sum()%10007);
        bw.write(String.valueOf(Arrays.stream(resultArr[N-1]).sum()%10007));
        bw.flush();
    }
}
