package implementation.live.game;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 369 게임 규칙 관련 클래스
 */
public class BusanThreeSixNine extends ThreeSixNine {
    public BusanThreeSixNine(Player[] players, AtomicInteger clapCount) {
        super(players, clapCount, "Busan");
    }

    // 서울의 369 게임 규칙 적용 결과 값
    // 숫자에 3,6,9가 포함 시 포함 횟수 만큼 return -> clap, 그 외엔 return -> strNum
    @Override
    public String do369(int num) {
        String strNum = String.valueOf(num); // 숫자를 문자열로 변환 -> Contains 사용 위함
        char[] clapNums = {'3','6','9'};
        StringBuilder sb = new StringBuilder();

        for (char c : clapNums) {
            for (int i = 0; i < strNum.length(); i++) {
                if (strNum.charAt(i) == c) {
                    sb.append("clap");
                    clapCount.incrementAndGet();
                }
            }
        }

        return (sb.length() != 0) ? sb.toString() : strNum;
    }
}
