import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        // 별(4) -> 동그라미(3) -> 네모(2) -> 세모(1) 순
        // 무승부 : D
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            int[] A = new int[4];                      //A카드 배열
            int[] B = new int[4];                      //B카드 배열
            String result = "D";                       //무승부

            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());

            for (int j = 0; j < a; j++) {
                int num = Integer.parseInt(st.nextToken());
                A[num - 1]++; //4를 입력받으면 A[3]값 증가
            }

            st = new StringTokenizer(br.readLine(), " ");
            int b = Integer.parseInt(st.nextToken());

            for (int j = 0; j < b; j++) {
                int num = Integer.parseInt(st.nextToken());
                B[num - 1]++;
            }

            for (int j = 3; j >= 0; j--) {
                if (A[j] > B[j]) {
                    result = "A";
                    break;
                } else if (A[j] < B[j]) {
                    result = "B";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}

