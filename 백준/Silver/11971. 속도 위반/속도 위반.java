import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Deque<int[]> ruleDrive = new ArrayDeque<>();
    Deque<int[]> tempDrive = new ArrayDeque<>();

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int distance = Integer.parseInt(st.nextToken());
      int speed = Integer.parseInt(st.nextToken());

      ruleDrive.offerLast(new int[]{distance, speed});
    }

    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int distance = Integer.parseInt(st.nextToken());
      int speed = Integer.parseInt(st.nextToken());

      tempDrive.offerLast(new int[]{distance, speed});
    }

    int max = 0;

    while(!ruleDrive.isEmpty()) {
      int[] rule = ruleDrive.pollFirst();
      int[] temp = tempDrive.pollFirst();

      int resultDistance = rule[0] - temp[0];
      int resultSpeed = rule[1] - temp[1];

      if(resultSpeed < 0) {
        max = Math.max(max, (resultSpeed * -1));
      }

      if(resultDistance > 0) {
        ruleDrive.offerFirst(new int[]{resultDistance, rule[1]});
      }

      if(resultDistance < 0) {
        tempDrive.offerFirst(new int[]{(resultDistance * -1), temp[1]});
      }
    }

    System.out.println(max);
  }

}
