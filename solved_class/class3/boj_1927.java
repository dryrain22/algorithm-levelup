package solved_class.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            switch (num) {
                case 0:
                    if(pq.isEmpty()) System.out.println(0);
                    else System.out.println(pq.poll());
                    break;
                default:
                    pq.offer(num);
                    break;
            }
        }
    }
}
