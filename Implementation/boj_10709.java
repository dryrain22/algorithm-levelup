package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10709 {
    static int h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        char[][] area = new char[h][w];
        int[][] dist = new int[h][w];

        // 거리 배열을 -1로 초기화
        for(int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], -1);
        }

        for (int i = 0; i < h; i++) {
            String weather = br.readLine();
            for (int j = 0; j < w; j++) {
                area[i][j] = weather.charAt(j);
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (area[i][j] == 'c') {
                    dist[i][j] = 0; // 이미 구름이 떠있으면 0

                    // 구름이 떠 있다면, 그 다음 지역에 대한 구름 예측 시간 계산
                    distCloud(i, j, area, dist);
                    break; // 만약 해당 줄에 구름이 떠있는 곳이 있다면, distCloud메서드로 해당 행은 완전 탐색 하기 때문에 break;
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void distCloud(int i, int j, char[][] area, int[][] dist) {
        int cnt = 0;

        for (int idx = j+1; idx < w; idx++) {
            if (area[i][idx] != 'c') {
                dist[i][idx] = ++cnt;
            } else {
                dist[i][idx] = 0;
                cnt = 0;
            }
        }
    }
}
