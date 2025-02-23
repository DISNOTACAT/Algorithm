import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;

    Deque<Character> stack = new ArrayDeque<>();

    while(!(s = br.readLine()).equals(".")) {

      s = s.replace(" ", "");

      stack.clear();

      String answer = "yes";

      for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if(c == '(' || c == '[') {
          stack.push(c);
          
        } else if(c == ')') {

          if(stack.isEmpty() || stack.pop() != '(')  {
            answer = "no";
            break;
          }

        } else if(c == ']') {

          if(stack.isEmpty() || stack.pop() != '[')  {
            answer = "no";
            break;
          }
        }

      }
      
      if(!stack.isEmpty()) {
        answer = "no";
      }

      System.out.println(answer);
    }
  }

}
