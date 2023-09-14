package solved_class.solved2_essential;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            int card_num = Integer.parseInt(st.nextToken());
            map.put(card_num, map.getOrDefault(card_num, 0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(map.getOrDefault(num, 0) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
