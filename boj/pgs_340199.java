package boj;

import java.util.*;

public class pgs_340199 {

    static class Solution {
        public int solution(int[] wallet, int[] bill) {
            // 길이가 긴쪽으로 반으로 접음
            // 홀수는 반으로 접은 후 나머지는 버림
            boolean flag = true;
            int answer = 0;
            int walletWidth = wallet[0];
            int walletHeight = wallet[1];

            while(flag) {
                int billWidth = bill[0]; // 지폐 가로
                int billHeight = bill[1]; // 지폐 세로

                if(billHeight < billWidth) {
                    billWidth /= 2;
                    answer++;
                } else if(billWidth < billHeight) {
                    billHeight /= 2;
                    answer++;
                }

                if((billWidth <= walletWidth && billHeight <= walletHeight)
                        || (billWidth <= walletHeight && billHeight <= walletWidth)) {
                    flag = false;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{50, 50}, new int[]{100,241}));
    }
}
