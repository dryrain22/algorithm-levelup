package solved_class.solved2_essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int total = Integer.parseInt(br.readLine());
        List<Integer> num = new ArrayList<>();

        for(int i = 0; i < total; i++) {
            num.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(num);

        for(int n : num) {
            sb.append(n).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}

public class boj_2751 {
    public static void main(String[] args) throws IOException {
        Solution2 solution = new Solution2();
        solution.solution();
    }
}
