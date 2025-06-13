import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<int[]> classTimesQue = new PriorityQueue<>((o1,o2) -> {
      if(o1[0] == o2[0]) return o1[1] - o2[1];
      else return o1[0] - o2[0];
    });

    for(int i = 0; i < N; i++) {
      int[] inputClassTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      classTimesQue.add(inputClassTime);
    }

    PriorityQueue<Integer> resultQue = new PriorityQueue<>();
    while(!classTimesQue.isEmpty()) {

      int[] curTime = classTimesQue.poll();
      int startTime = curTime[0];
      int endTime = curTime[1];

      if(resultQue.isEmpty()) {
        resultQue.add(endTime);
        continue;
      }

      if(resultQue.peek() <= startTime) {
        resultQue.poll();
      }

      resultQue.add(endTime);
    }

    System.out.println(resultQue.size());
  }

}
