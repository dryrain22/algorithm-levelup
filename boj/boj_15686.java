package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15686 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static int M;
    private static List<Point> homeList = new ArrayList<>();
    private static List<Point> chickenList = new ArrayList<>();
    private static boolean[] opened;

    private static long answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++) {
                // 1과 2가 위치한 좌표만 List
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    homeList.add(new Point(i, j));
                }

                if(num == 2) {
                    chickenList.add(new Point(i, j));
                }
            }
        }

        opened = new boolean[chickenList.size()];
        backTracking(0, 0);

        System.out.println(answer);
    }

    private static void backTracking(int idx, int cnt) {
        if(cnt == M) { // 폐업시키지 않을 치킨집을 모두 골랐으면 거리의 합 계산
            int result = 0;

            for(int i = 0; i < homeList.size(); i++) {
                int temp = Integer.MAX_VALUE; // 집이 변경되면 초기화

                for(int j = 0; j < chickenList.size(); j++) {
                    if(opened[j]) { // 치킨집이 열었으면
                        // 각 집에서 거리계산(오픈한 치킨집중 가장 가까운 곳으로 계산)
                        int distance = Math.abs(homeList.get(i).x - chickenList.get(j).x) + Math.abs(homeList.get(i).y - chickenList.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                result += temp;
            }

            answer = Math.min(answer, result); // 최소값 비교
            return;
        }

        if(cnt + (chickenList.size() - idx) < M){
            return;
        }
        
        backTracking(idx+1, cnt); // 치킨집을 선택하지 않았을 경우 재귀탐색
        
        opened[idx] = true;
        backTracking(idx+1, cnt+1); // 치킨집 선택했을 경우 재귀탐색
        opened[idx] = false; // 백트래킹
    }
}
