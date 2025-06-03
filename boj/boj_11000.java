package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_11000 {
    static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Time[] time = new Time[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            time[i] = new Time(start, end);
        }

        // 오름차순 정렬, 만약 시작시간이 같으면 종료시간으로 오름차순
        Arrays.sort(time, (t1, t2) -> t1.start != t2.start ? t1.start - t2.start : t1.end - t2.end);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 종료시간을 담을 우선순위 큐

        pq.offer(time[0].end); // 첫번째 종료시간을 pq에 삽입

        for(int i = 1; i < N; i++) {
            // Time배열의 시작시간을 순회하면서 종료시간과 비교
            if(pq.peek() <= time[i].start) { // 같은 강의실 사용가능!(시간대 안겹침)
                pq.poll(); // 다음 강의를 같은 강의실에서 사용가능 하므로 이전강의는 제거
            }

            pq.offer(time[i].end);
        }
        System.out.println(pq.size());
    }
}
