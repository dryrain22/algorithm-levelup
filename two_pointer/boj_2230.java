package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort((o1, o2) -> o1 - o2);

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while (start <= end && end < N) {
            int diff = list.get(end) - list.get(start);

            // 차이가 작을 경우
            if (diff < M) {
                end++;
            } else { // 차이가 클 경우
                min = Math.min(min, diff);
                start++;

            }
        }
        System.out.println(min);
    }
}
