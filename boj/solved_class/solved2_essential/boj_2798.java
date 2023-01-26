package solved_class.solved2_essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search(arr, N, M));
    }

    public static int search(int[] arr, int N, int M) {
        int max = 0;
        for(int i = 0; i < N-2; i++) {
            if(arr[i] >= M) continue;
            for(int j = i+1; j < N-1; j++) {
                if(arr[i] + arr[j] > M) continue;
                for(int k = j+1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum == M) return sum;
                    else if(sum < M && sum > max) max = sum;
                }
            }
        }
        return max;
    }

}
