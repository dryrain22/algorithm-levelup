package solved_class.solved2_essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_10828 {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            if(str.contains("push")) push_X(str.split(" ")[1]);
            else if(str.equals("pop")) System.out.println(pop());
            else if(str.equals("size")) System.out.println(size());
            else if(str.equals("empty")) System.out.println(empty());
            else if(str.equals("top")) System.out.println(top());
        }
    }

    public static void push_X(String x) {
        stack.push(Integer.parseInt(x));
    }

    public static int pop() {
        if(!stack.isEmpty()) {
            return stack.pop();
        } else {
            return -1;
        }
    }

    public static int size() {
        return stack.size();
    }

    public static int empty() {
        if(stack.isEmpty()) return 1;
        else return 0;
    }

    public static int top() {
        if(!stack.isEmpty()) return stack.peek();
        else return -1;
    }
}
