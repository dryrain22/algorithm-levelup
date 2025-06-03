package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9663 {
    static int[] queen; // 퀸이 위치한 열 배열
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queen = new int[N];

        backTracking(0);

        System.out.println(answer);
    }

    private static void backTracking(int row) {
        // Todo: 0부터 N까지 for문 반복하면서 depth+1 재귀탐색
        if(row == N) {
            answer++;
            return;
        }

        // col로 탐색
        for(int col = 0; col < N; col++) { // row: 행, col : 열
            queen[row] = col;
            // TODO: 이전에 위치한 퀸들과 충돌하는지 체크
            if(checkQueen(row)) {
                backTracking(row + 1);
            }
        }
    }

    // 같은 열, 대각선(기울기가 1) 에 있는지 체크
    private static boolean checkQueen(int row) {
        // 이전에 위치한 퀸들과 위치 비교
        for(int i = 0; i < row; i++) {
            if(queen[i] == queen[row]) return false; // 같은 열에 있는지 비교
            if(Math.abs(queen[row]-queen[i]) == Math.abs(row-i)) return false; // 대각선(기울기) 비교
        }

        return true;
    }
}
