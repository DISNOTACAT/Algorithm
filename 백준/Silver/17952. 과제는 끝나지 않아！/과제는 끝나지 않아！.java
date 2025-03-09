import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  static Deque<int[]> stack = new ArrayDeque<>();
  static int totalScore = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] now = new int[2];

    for(int i = 0; i < n; i++) {

      String[] input = br.readLine().split(" ");
      int type = Integer.parseInt(input[0]);

      if(type == 1) {
        if(now[1] > 0) {
          stack.push(now);
        }

        int score = Integer.parseInt(input[1]);
        int time = Integer.parseInt(input[2]);

        now = new int[]{score, time};
      }

      if(type == 0) {
        if(now[1] == 0  && !stack.isEmpty()) {
          now = stack.pop();
        }
      }

      now[1]--;

      if(now[1] == 0) {
        totalScore += now[0];
        now[0] = 0;
      }
    }

    System.out.print(totalScore);
  }

}
