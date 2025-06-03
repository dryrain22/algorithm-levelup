package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_19942 {

    private static int N;
    private static int ans = Integer.MAX_VALUE;
    private static boolean[] visited;
    private static List<Integer> resultList;

    static class Nutrients {
        int dan; // 단백질 최소 합
        int fat; // 지방 최소 합
        int tan; // 탄수화물 최소 합
        int vit; // 비타민 최소 합

        public Nutrients(int dan, int fat, int tan, int vit) {
            this.dan = dan;
            this.fat = fat;
            this.tan = tan;
            this.vit = vit;
        }
    }

    static class Food {
        Nutrients nutrients;
        int price;

        public Food(int dan, int fat, int tan, int vit, int price) {
            this.nutrients = new Nutrients(dan, fat, tan, vit);
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Food> foodList = new ArrayList<>();
        resultList = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        int dan = Integer.parseInt(st.nextToken());
        int fat = Integer.parseInt(st.nextToken());
        int tan = Integer.parseInt(st.nextToken());
        int vit = Integer.parseInt(st.nextToken());

        Nutrients nutrients = new Nutrients(dan, fat, tan, vit); // 영양소 최소 합 클래스 객체

        // 영양소 배열리스트 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            dan = Integer.parseInt(st.nextToken());
            fat = Integer.parseInt(st.nextToken());
            tan = Integer.parseInt(st.nextToken());
            vit = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            Food food = new Food(dan, fat, tan, vit, price);
            foodList.add(food);
        }

        backTracking(nutrients, foodList, 0);

        if (ans != Integer.MAX_VALUE) {
            System.out.println(ans);
            resultList.forEach(i -> System.out.print(i + " "));
        } else {
            System.out.println(-1); // 최소 가격을 만족하는 조합이 없으면 -1 출력
        }
    }

    static void backTracking(Nutrients nutrients, List<Food> foodList, int depth) {
        // 모든 재료를 다 탐색했을 때 재귀 종료

        if(depth == N) {
            int danSum = 0;
            int fatSum = 0;
            int tanSum = 0;
            int vitSum = 0;
            int price = 0;
            for(int i=0; i<N; i++) {
                if(visited[i]) {
                    danSum += foodList.get(i).nutrients.dan;
                    fatSum += foodList.get(i).nutrients.fat;
                    tanSum += foodList.get(i).nutrients.tan;
                    vitSum += foodList.get(i).nutrients.vit;
                    price += foodList.get(i).price;
                }
            }

            if(nutrients.dan <= danSum
                    && nutrients.fat <= fatSum
                    && nutrients.tan <= tanSum
                    && nutrients.vit <= vitSum) {
                if (price < ans) { // price가 최소값일때
                    ans = price; // 최소가격 갱신

                    resultList.clear(); // 갱신되면 리스트 비워주기
                    for(int i = 0; i < N; i++) {
                        if(visited[i]) {
                            resultList.add(i+1);
                        }
                    }
                }

                if(price == ans) {
                    List<Integer> tempList = new ArrayList<>();
                    for(int i = 0; i < N; i++) {
                        if(visited[i]) {
                            tempList.add(i+1);
                        }
                    }

                    if (!tempList.get(0).equals(resultList.get(0))) {
                        resultList = tempList;
                    } else {
                        for(int i=1; i<Math.min(tempList.size(), resultList.size()); i++) {
                            if (tempList.get(i) < resultList.get(i)) {
                                resultList = tempList;
                                break;
                            }
                        }
                    }
                }
            }
            return;
        }

        // 아직 재료 선택 하지 않았고, 최소 영양분을 못 채웠을 때 재귀
        backTracking(nutrients, foodList, depth+1); // 선택 안함

        visited[depth] = true; // 선택 함
        backTracking(nutrients, foodList, depth+1);
        visited[depth] = false; // Backtracking
    }
}
