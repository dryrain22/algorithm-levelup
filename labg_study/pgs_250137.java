package labg_study;

class Solution_250137 {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int nowHealth = health; // 현재체력 max체력으로 초기화
        int time = 0; // 현재진행시간(초)
        int cnt = 0; // 연속성공 시간( 공격 당하면 초기화)

        for(int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0]; // 몬스터 공격시간 변수

            while(true) { // 몬스터에게 공격당하기전까지 붕대질 while
                time++; // 진행시간, 연속성공시간 +1
                cnt++;

                // 현재시간이 몬스터한테 공격받는 시간이라면 break
                if(time == attackTime) {
                    cnt = 0;
                    break;
                }

                if(nowHealth != health) {
                    if(cnt == bandage[0]) { // 연속성공시간이 t면 현재체력 +x +y
                        nowHealth += bandage[1] + bandage[2];
                        nowHealth = Math.min(nowHealth, health);
                        cnt = 0; // 초기화
                    } else { // 연속성공시간이 t가 아니면 현재체력 +x
                        nowHealth += bandage[1];
                        nowHealth = Math.min(nowHealth, health);
                    }
                }
            }

            //공격당함!! (현재시간 = 몬스터 공격시간)
            nowHealth -= attacks[i][1]; // 현재체력 - 몬스터 공격데미지
            if(nowHealth <= 0) {
                return -1;
            }
        }
        return nowHealth;
    }
}

public class pgs_250137 {
    public static void main(String[] args) {
        Solution_250137 solution = new Solution_250137();
        System.out.println(solution.solution(new int[]{5,1,5}, 30, new int[][]{{2,10}, {9,15}, {10,5}, {11,5}}));
//        System.out.println(solution.solution(new int[]{1,1,1}, 5, new int[][]{{1,2}, {3,2}}));
    }
}
