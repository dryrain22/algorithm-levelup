package solved_class.solved2_essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10845 {
    static Queue<Integer> queue = new LinkedList<>();
    static int last = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.contains("push")) push_X(str.split(" ")[1]);
            else if(str.equals("pop")) System.out.println(pop());
            else if(str.equals("size")) System.out.println(size());
            else if(str.equals("empty")) System.out.println(empty());
            else if(str.equals("front")) System.out.println(front());
            else if(str.equals("back")) System.out.println(back());
        }
    }

    public static void push_X(String x) {
        queue.offer(Integer.parseInt(x));
        last = Integer.parseInt(x);
    }

    public static int pop() {
        if(!queue.isEmpty()) {
            return queue.poll();
        } else {
            return -1;
        }
    }

    public static int size() {
        return queue.size();
    }

    public static int empty() {
        if(queue.isEmpty()) return 1;
        else return 0;
    }

    public static int front() {
        if(queue.isEmpty()) return -1;
        else return queue.peek();
    }

    public static int back() {
        if(queue.isEmpty()) return -1;
        else return last;
    }
}
