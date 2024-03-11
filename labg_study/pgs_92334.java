package labg_study;


import java.util.*;

class Solution_92334 {
    private static final Map<String, Integer> reported_map = new HashMap<>(); // 신고당한사람, 횟수 Map
    private static final Map<String, HashSet<String>> reporter_map = new HashMap<>(); //신고자, 신고당한 자 list(중복 제거 set)

    public int[] solution(String[] id_list, String[] report, int k) {

        // report 배열을 set으로(2번 예시와 같이 같은 원소 값 중복 제거)
        for(String re : new HashSet<>(Arrays.asList(report))) {
            String[] str = re.split(" ");
            String reporter = str[0]; //신고자
            String reported = str[1]; //신고당한자

            reported_map.put(reported, reported_map.getOrDefault(reported, 0)+1); //해당 키 값이 없다면 1, 키 값이 있다면 해당 키의 value값+1
            reporter_map.putIfAbsent(reporter, new HashSet<>()); // 해당 키값이 없으면 new HashSet추가
            reporter_map.get(reporter).add(reported); // 키 값이 있으면 set에 reported 추가
        };

        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++) {
            answer[i] = sendMail(id_list[i], k);
        }

        return answer;
    }

    // 메일 발송 메서드
    private static int sendMail(String id, int k) {
        int cnt = 0;

        if(reporter_map.containsKey(id)) { // 신고자_map이 id key값을 가지는 지 체크
            for(String s : reporter_map.get(id)) { // 신고자 map에서 해당 id값의 value(신고당한 set)를 가져와 순차적으로 진행
                if(reported_map.get(s) >= k) { // set에서 가져온 id(신고당한 사람)의 누적횟수가 k회 이상 일 시 cnt++
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

public class pgs_92334 {
    public static void main(String[] args) {
        Solution_92334 solution = new Solution_92334();
        System.out.println(Arrays.toString(solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2)));
    }
}
