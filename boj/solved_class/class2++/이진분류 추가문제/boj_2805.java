package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * H : 높이, N : 나무의 수, M : 집으로 가져가려고 하는 나무의 길이
 * H 위의 높이부터 절단(나무 높이 > H 면 H로 맞춰짐) -> 잘려진 나무 높이만큼 집에 들고감(총으로 계산)
 * 적어도 M미터의 나무를 집에 가져가기 위한 H 의 최댓값?
 **/
public class boj_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] treeArr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        int min = 0; //하한선(lower bound)
        int max = 0; //상한선(upper bound)

        for(int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            treeArr[i] = tree;
            if(max < tree) max = tree;
        }

        while(min < max) {
            int mid = (min + max) / 2;
            long total = 0;
            for(int tree : treeArr) {
                if(mid < tree) total += tree-mid;
            }
            if(total < M) max = mid;
            else min = mid+1;
        }
        System.out.println(min - 1);
    }
}
