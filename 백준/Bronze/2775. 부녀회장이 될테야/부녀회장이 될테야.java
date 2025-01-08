import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  /*
    a층의 b호에는
    a-1 층에 1~b호까지의 사람 수 합만큼 산다.
    0층의 i호에는 i명이 산다

    a = 2
    b = 3

      1  2  3  호
    0 1  2  3
    1 1  3  6
    2 1  4  10   [a][b] = [a][b-1] + [a-1][b]
    층

   */


  public static void main(String[] args) throws IOException {
    solution();
  }

  private static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int p = Integer.parseInt(br.readLine());
    while (p-- > 0) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());

      int[][] dp = new int[k + 1][n + 1];

      // 0층 초기화
      for(int i = 1; i <= n; i++) {
        dp[0][i] = i;
      }

      for(int i = 1; i <= k; i++) {
        for(int j = 1; j <= n; j++) {
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }
      }

      System.out.println(dp[k][n]);
    }
  }

}
