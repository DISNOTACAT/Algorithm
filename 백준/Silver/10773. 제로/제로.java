import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Deque<Integer> list = new ArrayDeque<>();
    for(int i = 0; i < n; i++){
      int num = Integer.parseInt(br.readLine());

      if(num == 0) {
        list.pollLast();
      } else {
        list.addLast(num);
      }
    }

    int answer = 0;
    while(!list.isEmpty()){
      answer += list.poll();
    }
    System.out.println(answer);
  }

}
