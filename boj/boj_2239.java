package boj;

import java.io.*;

public class boj_2239 {
    private static int[][] sudoku = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            String num = br.readLine();

            for(int j = 0; j < num.length(); j++) {
                sudoku[i][j] = num.charAt(j) - '0';
            }
        }

        backTracking(0, 0); // (0, 0)에서 탐색 시작

    }

    private static void backTracking(int row, int col) throws IOException {
        if(col == 9) {
            // 다음 행 탐색시작
            backTracking(row+1, 0);
            return;
        }

        if(row == 9) {
            printSdoku();
            System.exit(0); // 프로그램 종료
        }

        // 0이면 가능한 숫자인지 판단!
        if(sudoku[row][col] == 0) {
            for(int i = 1; i <= 9; i++) {
                // 1부터 9까지의 숫자를 같은행, 열, 박스 안에 존재하는지 체크
                if(checkNum(row, col, i)) {
                    sudoku[row][col] = i;
                    backTracking(row, col+1);
                    sudoku[row][col] = 0; // 다른 경우의 수 판별을 위해 초기화
                }
            }
        } else {
            backTracking(row, col+1); // 0이 아닐때도 탐색해야함
        }
    }

    private static boolean checkNum(int row, int col, int num) {
        // 같은 행, 열에 같은 숫자가 있는지 확인
        for(int i = 0; i < 9; i++) {
            if(sudoku[row][i] == num) {
                return false;
            }

            if(sudoku[i][col] == num) {
                return false;
            }
        }

        // 같은 박스안에 존재하는지 체크
        // 해당 좌표가 위치한 박스의 첫번째 좌표를 구함
        int firstRow = (row/3) * 3;
        int firstCol = (col/3) * 3;

        // 3 X 3 박스 체크
        for(int i = firstRow; i < firstRow+3; i++) {
            for(int j = firstCol; j < firstCol+3; j++) {
                if(sudoku[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printSdoku() throws IOException {
        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                bw.write(String.valueOf(sudoku[i][j]));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
