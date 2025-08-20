package implementation.live.game;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 369 게임 규칙 관련 클래스
 */
public class SeoulThreeSixNine extends ThreeSixNine {

    public SeoulThreeSixNine(Player[] players, AtomicInteger clapCount) {
        super(players, clapCount, "Seoul");
    }

    // 서울의 369 게임 규칙 적용 결과 값
    // 숫자에 3,6,9가 포함 시 return -> clap, 그 외엔 return -> strNum
    @Override
    public String do369(int num) {
        String strNum = String.valueOf(num); // 숫자를 문자열로 변환 -> Contains 사용 위함

        if (strNum.contains("3") || strNum.contains("6") || strNum.contains("9")) {
            clapCount.incrementAndGet();
            return "clap";
        } else {
            return strNum;
        }
    }
}
