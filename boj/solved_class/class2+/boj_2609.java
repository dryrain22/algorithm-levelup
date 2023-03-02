package solved_class.solved2_essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num1 = Integer.parseInt(str.split(" ")[0]);
        int num2 = Integer.parseInt(str.split(" ")[1]);

        int max = 0; // 최대공약수

        for(int i = 1; i <= Math.max(num1, num2); i++) {
            if(num1 % i == 0 && num2 % i == 0) max = i;
        }

        System.out.println(max);
        System.out.println((num1/max)*(num2/max)*max);
    }
}
