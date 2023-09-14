package solved_class.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11723 {
    static int bitset = 0;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = "";

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            if (str.contains("add")) {
                st = new StringTokenizer(str, " ");
                st.nextToken();
                add(Integer.parseInt(st.nextToken()));
            } else if (str.contains("check")) {
                st = new StringTokenizer(str, " ");
                st.nextToken();
                sb.append(check(Integer.parseInt(st.nextToken()))).append('\n');
            } else if (str.contains("remove")) {
                st = new StringTokenizer(str, " ");
                st.nextToken();
                remove(Integer.parseInt(st.nextToken()));
            } else if (str.contains("toggle")) {
                st = new StringTokenizer(str, " ");
                st.nextToken();
                toggle(Integer.parseInt(st.nextToken()));
            } else if (str.equals("all")) {
                all();
            } else if (str.equals("empty")) {
                empty();
            }
        }
        System.out.println(sb.toString());
    }

    public static void add(int n) {
        bitset |= (1 << n);
    }

    public static int check(int n) {
        if ((bitset & (1 << n)) != 0) return 1;
        else return 0;
    }

    public static void remove(int n) {
        bitset &= ~(1 << n);
    }

    public static void toggle(int n) {
        bitset ^= (1 << n);
    }

    public static void all() {
        bitset = (1 << 21) -1;
    }

    public static void empty() {
        bitset = 0;
    }
}

