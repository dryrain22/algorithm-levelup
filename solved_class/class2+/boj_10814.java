package solved_class.solved2_essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList<String>> map = new TreeMap<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            map.computeIfAbsent(age, key -> new ArrayList<>()).add(name);
        }

        for(Map.Entry<Integer, ArrayList<String>> entryset : map.entrySet()) {
            for(String value : entryset.getValue()) {
                System.out.println(entryset.getKey() + " " + value);
            }

        }
    }
}
