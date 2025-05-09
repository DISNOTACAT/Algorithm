import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] arr = new int[N+1][2];
    for(int i = 1; i <= N; i++){
      String[] str = br.readLine().split(" ");
      arr[i][0] = Integer.parseInt(str[0]);
      arr[i][1] = Integer.parseInt(str[1]);
    }

    int[] dp = new int[N+1];
    for(int i = 1; i <= N; i++){

      int time = arr[i][0] - 1;
      int price = arr[i][1];

      if(time == 0) {

        dp[i] = Math.max(dp[i], dp[i-1] + price);

      } else {

        dp[i] = Math.max(dp[i],dp[i-1]);

        if(time <= (N-i)) {
          dp[i+time] = Math.max(dp[i+time], dp[i-1] + price);
        }
      }
    }

    System.out.println(dp[N]);
  }

}
