package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long cnt = 0;

        for (int i = 0; i < N - 2; i++) {
            int start = i + 1;
            int end = N - 1;

            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];

                if (sum == 0) {
                    // 중복값이 있을 경우에 그 갯수만큼 +
                    // 오름차순 정렬했기에 start와 end가 같다면 그 사이의 모든 값이 같다.
                    if (arr[start] == arr[end]) {
                        int n = end - start + 1;
                        cnt += (long) n * (n - 1) / 2; // nC2
                        break;
                    } else {
                        int s = 1;
                        int e = 1;
                        while (start - arr[start + s] == arr[start]) s++;
                        while (end - e > start && arr[end - e] == arr[end]) e++;

                        cnt += (long) s * e;
                        start += s;
                        end -= e;
                    }
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(cnt);
    }
}
