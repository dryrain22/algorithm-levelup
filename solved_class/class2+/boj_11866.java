package solved_class.solved2_essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }
        sb.append("<");
        while(!q.isEmpty()) {
            for(int i = 0; i < K; i++) {
                if(i!=K-1) {
                    q.offer(q.poll());
                } else {
                    sb.append(q.poll()).append(",").append(" ");
                }
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());
    }
}
