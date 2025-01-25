import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    solution();
  }

  private static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    long[] dp = new long[N + 1];

    if(N == 0) {
      System.out.println(0);
      return;
    }
    
    if(N == 1 || N == 2) {
      System.out.println(1);
      return;
    }

    dp[0] = 0L;
    dp[1] = 1L;

    for(int i = 2; i <= N; i++){
      dp[i] = dp[i-1] + dp[i-2];
    }

    System.out.print(dp[N]);
  }
}
