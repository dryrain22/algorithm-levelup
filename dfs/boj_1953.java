package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1953 {
    private static boolean[] visited;
    private static final ArrayList<ArrayList<Integer>> teams = new ArrayList<>();
    private static final ArrayList<ArrayList<Integer>> hates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visited = new boolean[n+1];

        for (int i = 0; i < 2; i++) {
            teams.add(i, new ArrayList<>());
        }

        for (int i = 0; i <= n; i++) {
            hates.add(i, new ArrayList<>());
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());

            for(int j = 0; j < m; j++) {
                int k = Integer.parseInt(st.nextToken());
                hates.get(i).add(k);
            }
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                DFS(i, 0);
            }
        }

        sortTeams();
        answer(0);
        answer(1);
        // 1 -> 3 , 2 -> 5, 3->1,4, 4-> 3, 5->2
    }

    private static void sortTeams() {
        Collections.sort(teams.get(0));
        Collections.sort(teams.get(1));
    }

    private static void answer(int idx) {
        System.out.println(teams.get(idx).size());
        for(Integer team : teams.get(idx)) {
            System.out.print(team +" ");
        }
        System.out.println();
    }

    private static void DFS(int now, int depth) {
        if(!visited[now]) {
            visited[now] = true;
            teams.get(depth % 2).add(now);

            for(Integer hate : hates.get(now)) {
                DFS(hate, depth+1);
            }
        }
    }
}
