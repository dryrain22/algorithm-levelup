package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 높이 V미터인 막대
 * 달팽이 낮 : A미터 올라감
 *       밤 : B미터 떨어짐
 * 정상까지 며칠?
 */
public class boj_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int move = up - down; //실질적인 하루 이동거리
        /** height에 down을 뺴주는 이유
         * 정상에 도달하면 미끄러지지 않는다는 조건이 있기에,
         * down 일수는 up 일수보다 항상 적을 수 밖에 없다.
         * 따라서 걸리는 최소한의 일수를 구하기 위해선, 마지막 날의 미끄러짐을 생략하고 구해야한다.
         * 대신 그렇게 해서도 나누어 떨어지지 않는다면, 올라가야 할 높이가 남아있다는 것이므로 +1 해준다.
         */
        int day = (height - down) / move;
        if((height - down) % move != 0) day++;
        System.out.println(day);
    }
}
