package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] today = new int[N];
        long left = 0;
        long right = 0;

        for(int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            today[i] = money;
            left = (today[i] > left ? today[i] : left);
            right += today[i];
        }

        // 구간을 배열의 최대값 <= K <= 배열 전체의 합
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            long cnt = 0;
            for(int t : today) {
                if(sum + t > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += t;
            }
            if(sum != 0) cnt++;
            //뽑는 금액 더 낮춰야함
            if(cnt <= M) right = mid - 1;
            else left = mid + 1;
        }
        System.out.println(left);
    }
}
