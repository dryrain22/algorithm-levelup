package labg_study;

import java.util.HashMap;
import java.util.Map;

/**
 choices	뜻
 1	매우 비동의
 2	비동의
 3	약간 비동의
 4	모르겠음
 5	약간 동의
 6	동의
 7	매우 동의

survey 원소 첫번쨰: 비동의 관련 선택지
        두번째: 동의 관련 선택지
        **/
// "AN", "CF", "MJ", "RT", "NA"}, {5, 3, 2, 7, 5}
class Solution_118666 {
    public String solution(String[] survey, int[] choices) {

        Map<String, Integer> cntMap = new HashMap<>();
        cntMap.put("R", 0);
        cntMap.put("T", 0);
        cntMap.put("C", 0);
        cntMap.put("F", 0);
        cntMap.put("J", 0);
        cntMap.put("M", 0);
        cntMap.put("A", 0);
        cntMap.put("N", 0);

        for(int i = 0; i < survey.length; i++) {
            String first = String.valueOf(survey[i].charAt(0)); // 첫번째 원소는 비동의 관련 원소
            String second = String.valueOf(survey[i].charAt(1)); // 두번째 원소는 동의 관련 원소

            switch (choices[i]) {
                case 1:
                    cntMap.put(first, cntMap.get(first) + 3);
                    break;
                case 2:
                    cntMap.put(first, cntMap.get(first) + 2);
                    break;
                case 3:
                    cntMap.put(first, cntMap.get(first) + 1);
                    break;
                case 5:
                    cntMap.put(second, cntMap.get(second) + 1);
                    break;
                case 6:
                    cntMap.put(second, cntMap.get(second) + 2);
                    break;
                case 7:
                    cntMap.put(second, cntMap.get(second) + 3);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(cntMap.get("R") >= cntMap.get("T")) sb.append("R");
        else sb.append("T");

        if(cntMap.get("C") >= cntMap.get("F")) sb.append("C");
        else sb.append("F");

        if(cntMap.get("J") >= cntMap.get("M")) sb.append("J");
        else sb.append("M");

        if(cntMap.get("A") >= cntMap.get("N")) sb.append("A");
        else sb.append("N");

        String answer = sb.toString();
        return answer;
    }
}

public class pgs_118666 {
    public static void main(String[] args) {
        Solution_118666 solution = new Solution_118666();
        solution.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
    }
}
