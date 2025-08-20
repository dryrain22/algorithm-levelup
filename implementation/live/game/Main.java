package implementation.live.game;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player[] players = new Player[]{
                new Player("짱구", 10),
                new Player("유리", 2),
                new Player("철수", 8),
                new Player("맹구", 0)
        };

        AtomicInteger clapCount = new AtomicInteger(0);

        ThreeSixNine thread1 = new SeoulThreeSixNine(players, clapCount);
        ThreeSixNine thread2 = new BusanThreeSixNine(players, clapCount);

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(thread1);
        pool.execute(thread2);

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("모든 게임의 총 박수 횟수는 : " + clapCount);
    }
}
