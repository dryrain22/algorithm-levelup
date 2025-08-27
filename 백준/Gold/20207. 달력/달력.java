import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] calendar = new int[366];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int inputMax = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            inputMax = Math.max(inputMax, e);

            for (int j = s; j <= e; j++) {
                calendar[j]++;
            }
        }

        System.out.println(coating(inputMax));
    }

    private static int coating(int inputMax) {
        int answer = 0;
        for (int i = 1; i <= inputMax; i++) {
            if (calendar[i] != 0) {
                int start = i;
                int max = 0;
                while (i <= inputMax && calendar[i] != 0) {
                    max = Math.max(max, calendar[i]);
                    i++;
                }
                answer += (max * (i-start));
            }
        }

        return answer;
    }
}
