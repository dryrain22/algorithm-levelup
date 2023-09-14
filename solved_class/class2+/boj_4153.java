package solved_class.solved2_essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken()); int num2 = Integer.parseInt(st.nextToken()); int num3 = Integer.parseInt(st.nextToken());

            if(num1 == 0 && num2 == 0 && num3 == 0) {
                break;
            }
            else {
                pq.offer(num1); pq.offer(num2); pq.offer(num3);
                if(Math.pow(pq.poll(), 2) == Math.pow(pq.poll(), 2)+ Math.pow(pq.poll(),2)) System.out.println("right");
                else System.out.println("wrong");
            }
        }
    }
}
