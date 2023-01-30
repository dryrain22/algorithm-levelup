package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이진분류 문제
public class boj_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] line = new int[K];
        long max = 0L; //상한선
        long min = 0L; //하한선

        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            line[i] = num;
            if(max < num) max = num;
        }
        
        max += 1; //랜선이 [1,1] 인 경우 max=1, min=0 -> mid가 0인 경우 방지하기 위함

        //upper bound형식 -> lower bound형식은 조건식이 if(cnt <= N) 이렇게 되어야함(특정 K값보다 같거나 큰 값이 처음나오는 위치찾기위함)
        while(min < max) {
            long cnt = 0L;
            long mid = (max + min) / 2L;

            for(int l : line) {
                if(mid <= l) cnt += l / mid;
            }
            if(cnt <= N) max = mid;
            else min = mid + 1;
            System.out.println("max: " + max);
            System.out.println("min: " + min);
        }
        System.out.println(min);
    }
}
