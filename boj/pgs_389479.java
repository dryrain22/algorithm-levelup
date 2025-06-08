package boj;

import java.util.LinkedList;
import java.util.Queue;

public class pgs_389479 {
    public int solution(int[] players, int m, int k) {
        // + m명 : 서버 1대 증설
        // 서버 k 시간 운영 -> 반납
        Queue<int[]> queue = new LinkedList<>();
        int nowCnt = 0; // 현재 증설된 서버 count
        int answer = 0; // 증설된 서버 count


        for(int i = 0; i < players.length; i++) {
            int p = players[i];

            // 만료된 서버 내리기
            while(!queue.isEmpty() && queue.peek()[0] == i) {
                nowCnt -= queue.poll()[1];
            }

            if(p == 0) {
                continue;
            }

            if(p/m > 0) {
                int needCnt = p/m; // 현재 필요로 하는 서버 count
                int moreCnt = (needCnt - nowCnt); // 추가로 증설된 서버 count

                if(moreCnt > 0) { // 추가로 증설된 서버가 있다면
                    queue.add(new int[]{i+k, moreCnt}); // 만료시간과 추가로 증설된 서버 count Queue에 삽입
                    nowCnt += moreCnt;
                    answer += moreCnt;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        pgs_389479 pgs_389479 = new pgs_389479();
        System.out.println(pgs_389479.solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5));
    }
}
