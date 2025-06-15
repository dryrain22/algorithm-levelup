package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_11725 {
    static ArrayList<Integer>[] adjacencyList; // 인접 노드 저장(인접배열리스트)
    static int[] parentNode;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parentNode = new int[N+1];

        adjacencyList = new ArrayList[N+1];
        isVisited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            adjacencyList[node1].add(node2);
            adjacencyList[node2].add(node1);
        }

        DFS(1); // Root Node가 1이므로 1부터 시작

        for (int i = 2; i < N+1; i++) {
            System.out.println(parentNode[i]);
        }
    }

    private static void DFS(int node) {
        isVisited[node] = true; // 방문 Node : True

        for (int idx : adjacencyList[node]) {
            if (!isVisited[idx]) {
                parentNode[idx] = node;
                DFS(idx);
            }
        }
    }
}
