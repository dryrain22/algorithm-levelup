package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = "";

        while (true) {
            sentence = br.readLine();
            if (sentence.equals(".")) break;

            System.out.println(doVerify(sentence));
        }
    }

    static String doVerify(String sentence) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return "no";
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return "no";
                }
            }
        }

        if (stack.isEmpty()) return "yes";
        else return "no";
    }
}

