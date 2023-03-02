package solved_class.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class boj_1463 {

    static class Node {
        int num;
        int count;

        public Node (int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[num + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(num, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            num = node.num;

            if (num == 1) {
                System.out.println(node.count);
                break;
            }
            if (num > 1 && !visited[num]) {
                visited[num] = true;
                int count = node.count+1;
                if(num % 3 == 0) queue.offer(new Node(num / 3, count));
                if(num % 2 == 0) queue.offer(new Node(num / 2, count));
                queue.offer(new Node(num-1, count));
            }
        }
    }
}
