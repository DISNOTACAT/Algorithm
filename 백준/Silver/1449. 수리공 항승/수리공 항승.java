import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int cracks = Integer.parseInt(st.nextToken());
    int tape = Integer.parseInt(st.nextToken());

    if(tape == 1) {
      System.out.println(cracks);
      return;
    }

    PriorityQueue<Integer> que = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < cracks; i++) {
      que.add(Integer.parseInt(st.nextToken()));
    }

    int result = 0;

    while(!que.isEmpty()) {

      int start = que.poll();

      if(que.isEmpty()) {
        result++;
        break;
      }

      int gap = 0;
      while(gap < tape && !que.isEmpty()) {

        int endPoint = que.poll();
        gap = endPoint - start + 1;

        if(gap > tape) {
          que.add(endPoint);
          break;
        }
      }
      result++;
    }
    System.out.println(result);
  }
}
