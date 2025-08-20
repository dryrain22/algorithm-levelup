package implementation.live.game;


public class Player {
    String name;
    double errorRate;

    protected Player(String name, double errorRate) {
        this.name = name;
        this.errorRate = errorRate;
    }

    // 플레이어의 오답률은 0~100사이의 숫자(소수점도 가능)
    // 자신의 차례에서 오답이 아닌지 판별
    // 플레이어의 고유한 오답률을 가지고, 랜덤한 숫자와 비교하여 판단
    public boolean isErrorAnswer(double errorRate) {
        double random = Math.random(); // 0에서 1 사이의 숫자

        return random * 100 < errorRate; // random * 100값이 0과 errorRate 사이 값인 경우 에러
    }
}
