import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int notZeroCnt = 0;
        block = new int[w];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(st.nextToken());

            if(block[i] != 0) {
                notZeroCnt++;
            }
        }

        // 블록이 0이 아닌 갯수가 1개 이하일 경우, 빗물은 채울 수 없으므로 0 리턴
        if (notZeroCnt <= 1) {
            System.out.println(0);
        } else {
            System.out.println(getRainyArea(h, w));
        }
    }

    private static int getRainyArea(int h, int w) {
        int answer = 0;

        for(int i = 1; i < w-1; i++) {
            int leftMaxBlock = findMaxBlock(0, i);
            int rightMaxBlock = findMaxBlock(i+1, w);

            // 현재 블럭이 왼쪽 최대 블럭과 오른쪽 최대 블럭 사이에 있어야 빗물이 찰 수 있음
            if(block[i] < leftMaxBlock && block[i] < rightMaxBlock) {
                answer += Math.min(leftMaxBlock, rightMaxBlock) - block[i];
            }
        }

        return answer;
    }

    private static int findMaxBlock(int s, int e) {
        int max = 0;

        for(int i = s; i < e; i++) {
            max = Math.max(max, block[i]);
        }
        return max;
    }
}
