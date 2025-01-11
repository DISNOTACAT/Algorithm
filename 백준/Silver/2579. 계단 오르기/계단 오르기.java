import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  /*
    시작 지점에서 1칸 또는 2칸씩 이동하여 나오는 최대 값
    단 연속 3칸을 움직일 수는 없다.
    그럼 연속되었는지는 어떻게 확인하는가?
    1. 다 검사하고 연속되었다면 다시 하기 --> 절대 불가능함
    2. bottom-up 으로 검사하면서 연속되면 제외?
    이거 뭔가 재귀가 필요할 거같다
    그렇다면 top-down 으로 진행한다.

    무조건 3연속이 안된다면 진행할 수 있는 방법은
    +1 +1 +2
    +1 +2 +1
    +1 +2 +2
    +2 +1 +1
    +2 +2 +1
    +2 +2 +2

    위에서 아래로 본다면
    가장 위에 칸은 직전 또는 전전에서 온 값의 합이다.
    직전에 서 온경우 전 값은 2칸 전에서 온 값이어야한다.
    전전에서 온경우 이전 값은 직전 또는 전전에서 온 값이다.

    n = n + (n-1) + (n-3)
    n = n + (n-2)

   */

  public static void main(String[] args) throws IOException {
    solution();
  }
  private static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];
    int[] stairs = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }

    if (n == 1) {
      System.out.println(stairs[1]);
      return;
    }

    if (n == 2) {
      System.out.println(Math.max(stairs[2], stairs[1] + stairs[2]));
      return;
    }

    // 초기값 설정
    dp[0] = 0; // 시작 지점은 계단 점수가 없음
    dp[1] = stairs[1];
    dp[2] = stairs[1] + stairs[2];

    // 점화식으로 DP 배열 채우기
    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
    }

    System.out.println(dp[n]);
  }

}
