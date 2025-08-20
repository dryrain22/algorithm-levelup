package implementation.live.game;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 369 게임 규칙 관련 추상 클래스
 * 서울, 부산 규칙이 상이
 */
public abstract class ThreeSixNine implements Runnable {

    Player[] players;
    AtomicInteger clapCount;
    String region;

    public ThreeSixNine(Player[] players, AtomicInteger clapCount, String region) {
        this.players = players;
        this.clapCount = clapCount;
        this.region = region;
    }

    // player는 4명, 숫자는 100까지
    public void playGame() {
        int num = 1;

        while(num <= 100) {
            int idx = (num-1)% players.length;
            Player player = players[idx];
            if (player.isErrorAnswer(player.errorRate)) break; // 게임종료

            String result = do369(num);
            System.out.println("["+region+"]" + player.name + ": " + result);

            num++;
        }
    }

    public abstract String do369(int num);

    @Override
    public void run() {
        playGame();
    }
}
