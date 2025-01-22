import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  /*
    1로 시작해야한다.
    1이 연속으로 나올 수 없다.

    10 을 하나의 묶음으로
    n = 2 >> 1 {10}
    n = 3 >> 2 {101, 100}
    n = 4 >> 3 {1000. 1001. 1010}
    n = 5 >> 5 {10000, 10001, 10010, 10100, 10101}
    n = 6 >> 8 {100000, 100001, 100010, 100100, 101000, 101001, 101010, 100101}
        -> 6의 값은 (n-2) + (n-1)


   */


  public static void main(String[] args) throws IOException {
    solution();
  }

  private static Long[] dp;

  private static void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    dp = new Long[n + 1];

    if(n <= 2) {
      System.out.println(1);
      return;
    }

    if(n == 3) {
      System.out.println(2);
      return;
    }

    dp[2] = 1L;
    dp[3] = 2L;

    for(int i = 4; i <= n; i++){
      dp[i] = dp[i-2] + dp[i-1];
    }

    System.out.println(dp[n]);
  }

}
