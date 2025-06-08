package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] str = new String[N];
        String[] set = new String[M];

        int answer = 0;

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            set[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            String find = set[i];

            for (int j = 0; j < N; j++) {
                if (str[j].equals(find)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
