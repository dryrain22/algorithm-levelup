package labg_study;

import java.util.ArrayList;
import java.util.List;

class Solution_17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize != 0) {
            List<String> cacheList = new ArrayList<>(); // 캐시를 담을 List생성
            for(int i = 0; i < cities.length; i++) {
                String city = cities[i].toLowerCase(); // 대소문자 구분안하니, 소문자로 입력 통일
                if(cacheList.size() != cacheSize) {  // 캐시리스트가 캐시사이즈 만큼 안채워졌다면
                    if(cacheList.contains(city)) { // 캐시가 해당 문자열을 포함하면
                        cacheList.remove(city); // 해당 문자열 제거
                        cacheList.add(city);   // 다시 추가(제거하고 다시 추가하는 이유는 최신화 시키기 위함) -> LRU는 가장 오래전에 참조한 페이지를 삭제하는 것 -> 가장 최신은 리스트 index 맨 뒤로
                        answer++;
                    } else {
                        cacheList.add(city);
                        answer += 5;
                    }
                } else { // 리스트가 가득 찼다면
                    if(cacheList.contains(city)) {
                        cacheList.remove(city);
                        cacheList.add(city);
                        answer++;
                    } else {
                        cacheList.remove(0); // 맨 앞 원소 제거(가장 노후화? 된 원소 제거)
                        cacheList.add(city); // 리스트 맨 뒤에 가장 최신의 원소 추가
                        answer += 5;
                    }

                }

            }
        }
        else {
            answer = 5 * cities.length;
        }

        return answer;
    }
}

public class pgs_17680 {
    public static void main(String[] args) {
        Solution_17680 solution = new Solution_17680();
        System.out.println(solution.solution(3, 	new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}
