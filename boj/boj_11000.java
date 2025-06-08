package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_11000 {
    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Lecture[] lecture = new Lecture[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lecture[i] = new Lecture(start, end);
        }

        Arrays.sort(lecture, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
        pq.offer(lecture[0].end); // 종료시간 pq에 삽입

        for(int i = 1; i < lecture.length; i++) {
            if(pq.peek() <= lecture[i].start) {
                pq.poll();
            }

            pq.offer(lecture[i].end);
        }

        System.out.println(pq.size());
    }
}
