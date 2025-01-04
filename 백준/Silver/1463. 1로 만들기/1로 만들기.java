import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


  public static void main(String[] args) throws IOException {
    solution();
  }

  /*
    Bottom-up 방식 풀이
    1 에서 부터 N 이 되는 최소값을 찾는다.
   */

  private static void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n + 1];
    dp[1] = 0;

    for(int i = 2; i <= n; i++) {
      // -1 하는 방법의 수 -> 앞의 수까지 만드는 방법에서 + 1
      dp[i] = dp[i-1] + 1;

      // 2의 배수라면, 2의 배수로 만드는 방법과 -1 하는 방법을 비교
      if(i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i/2] + 1);
      }
      // 3의 배수라면,,
      if(i % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i/3] + 1);
      }
      // 이렇게 n 까지 가는 최솟값을 만들어냄
    }
    System.out.println(dp[n]);
  }
}
