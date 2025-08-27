import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] childrenNode;
    static List<String>[] files;
    static Map<String, Integer> folderIdMap = new HashMap<>(); // 입력받은 폴더명을 숫자로 변환

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 폴더 총 개수
        int m = Integer.parseInt(st.nextToken()); // 파일 총 개수

        childrenNode = new ArrayList[n+1];  // 인접 리스트 (폴더 -> 자식 폴더)
        for (int i = 0; i <= n; i++) childrenNode[i] = new ArrayList<>();

        files = new ArrayList[n+1];      // 각 폴더에 속한 파일들
        for (int i = 0; i <= n; i++) files[i] = new ArrayList<>();

        int nextId = 0;

        // 메인폴더는 루트, 그 외 폴더는 자식노드, 파일은 노드의 속성 값으로
        for (int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String p = st.nextToken();
            String f = st.nextToken();
            int c = Integer.parseInt(st.nextToken());

            if (!folderIdMap.containsKey(p)) {
                folderIdMap.put(p, nextId++);
            }

            // 두번째 입력 값이 폴더일 경우
            if (c == 1) {
                if (!folderIdMap.containsKey(f)) {
                    folderIdMap.put(f, nextId++);
                }
                childrenNode[folderIdMap.get(p)].add(folderIdMap.get(f));
            } else {
                files[folderIdMap.get(p)].add(f); // 파일명 그대로 삽입
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split("/");
            String lastFileName = query[query.length - 1];

            int folderId = folderIdMap.get(lastFileName);

            Set<String> fileSet = new HashSet<>();
            int answer = dfs(folderId, fileSet);
            System.out.println(fileSet.size() + " " + answer);
        }
    }

    private static int dfs(int startNode, Set<String> fileSet) {
        int answer = 0;

        // 현재 폴더의 파일 추가
        if (!files[startNode].isEmpty()) {
            answer += files[startNode].size();
            fileSet.addAll(files[startNode]);
        }

        // 자식 폴더 순회
        for (int node : childrenNode[startNode]) {
            answer += dfs(node, fileSet);
        }
        return answer;
    }
}
