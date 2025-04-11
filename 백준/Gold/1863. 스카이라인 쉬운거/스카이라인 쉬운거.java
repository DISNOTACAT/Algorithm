import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Deque<Integer> stack = new ArrayDeque<>();
    int result = 0;

    while(N --> 0) {

      String[] build = br.readLine().split(" ");
      int curHeight = Integer.parseInt(build[1]);

      if(curHeight == 0) {
        result += stack.size();
        stack.clear();
        continue;
      }

      while(!stack.isEmpty()) {


          int peekHeight = stack.peekFirst();

        if(peekHeight == curHeight) {
          stack.pop();
        }

        if(peekHeight > curHeight) {
          stack.pop();
          result++;
        } else break;
      }

      stack.push(curHeight);
    }

    result += stack.size();
    System.out.println(result);
  }

}
