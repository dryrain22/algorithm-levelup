package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_10733 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if(!stack.isEmpty() && num == 0) stack.pop();
            else stack.push(num);
        }

        int sum = 0;
        for(int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }
        System.out.println(sum);
    }
}
