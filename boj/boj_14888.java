package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {
    private static int N;
    private static int[] numArr;
    private static int[] calc = new int[4]; // 연산자는 4개
    private static int start;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        // 음수를 양수로 나눌때 -> 양수로 바꾼뒤 몫을 취하고 음수로 변환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        start = numArr[0];
        backTracking(start,1); // 첫번째 숫자는 고정이므로 다음 depth부터

        System.out.println(max);
        System.out.println(min);

    }

    private static void backTracking(int total, int depth) {
        // 끝까지 탐색했다면 return
        if(depth == N) {
            min = Math.min(min, total);
            max = Math.max(max, total);

            return;
        }

        for(int i = 0; i < 4; i++) {
            if(calc[i] > 0) {
                // 선택
                calc[i] -= 1;
                backTracking(calculation(i, total, numArr[depth]), depth+1);
                calc[i] += 1; // 백트래킹(선택 해제)
            }
        }
    }



    // 해당 연산자로 계산 메서드
    // calc: 연산자가 위치한 인덱스, total: 해당 연산자로 계산 전에 구한 합계, targetNum: 연산을 할 새로운 숫자
    private static int calculation(int calc, int total, int targetNum) {
        // 덧셈
        if(calc == 0) {
            return total + targetNum;
        }
        // 뺄셈
        if(calc == 1) {
            return total - targetNum;
        }
        // 곱셈
        if(calc == 2) {
            return total * targetNum;
        }
        // 나눗셈
        if(calc == 3) {
            if(total < 0) {
                total = Math.abs(total); // 양수로 변환
                return (total/targetNum) * -1;
            }

            return total / targetNum;
        }
        return -1; // 그 외의 경우는 없으니 아무거나 return
    }
}
