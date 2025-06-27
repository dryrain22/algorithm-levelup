package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1198 {
    static int[][] shape;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        shape = new int[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            shape[i][0] = Integer.parseInt(st.nextToken());
            shape[i][1] = Integer.parseInt(st.nextToken());
        }

        double max = 0;
        // 점 세개로 만들 수 있는 삼각형 중에 넓이가 가장 최대값
        for (int i = 0; i < N-2; i++) {
            for (int j = i + 1; j < N-1; j++) {
                for (int k = i + 2; k < N; k++) {
                    max = Math.max(max, calculateArea(shape[i], shape[j], shape[k]));
                }
            }
        }
        System.out.println(max);
    }

    private static double calculateArea(int[] a, int[] b, int[] c) {
        return (double) Math.abs((a[0] * b[1] + b[0] * c[1] + c[0] * a[1]) -
                    (b[0] * a[1] + c[0] * b[1] + a[0] * c[1]))/2;
    }
}
