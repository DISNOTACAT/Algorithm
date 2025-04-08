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

    while(N --> 0) {

      String[] inputs = br.readLine().split(" ");
      String command = inputs[0];

      if(command.equals("push")) {
        stack.push(Integer.parseInt(inputs[1]));
      }

      if(command.equals("pop")) {

        if(stack.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.pop());
        }
      }

      if(command.equals("size")) {
        System.out.println(stack.size());
      }

      if(command.equals("empty")) {
        System.out.println(stack.isEmpty()? 1 : 0);
      }

      if(command.equals("top")) {

        if(stack.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.peek());
        }
      }
    }
  }

}
