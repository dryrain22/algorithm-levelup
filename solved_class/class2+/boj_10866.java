package solved_class.solved2_essential;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = 0;
            String order = br.readLine();
            StringTokenizer st = new StringTokenizer(order, " ");

            switch (st.nextToken()) {
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    dq.offerLast(num);
                    break;
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    dq.offerFirst(num);
                    break;
                case "front":
                    System.out.println((!dq.isEmpty()) ? String.valueOf(dq.peekFirst()) : -1);
                    break;
                case "back":
                    System.out.println((!dq.isEmpty()) ? String.valueOf(dq.peekLast()) : -1);
                    break;
                case "pop_front":
                    System.out.println((!dq.isEmpty()) ? String.valueOf(dq.pollFirst()) : -1);
                    break;
                case "pop_back":
                    System.out.println((!dq.isEmpty()) ? String.valueOf(dq.pollLast()) : -1);
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    System.out.println((!dq.isEmpty()) ? 0 : 1);
                    break;
            }
        }
        br.close();
    }
}