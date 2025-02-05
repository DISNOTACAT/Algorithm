
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    if(!s.contains("0") || !s.contains("1")) {
      System.out.println(0);
      return;
    }

    int cnt = 0;
    int reverseCnt = 0;
    Deque<Character> stack = new ArrayDeque<>();
    stack.addLast(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      char c = stack.getLast();
      if(s.charAt(i) == c || s.charAt(i) == s.charAt(0)) {
        stack.addLast(s.charAt(i));
      } else {
        cnt ++;
        stack.addLast(s.charAt(i));
      }
    }

    String reverse = new StringBuilder(s).reverse().toString();
    Deque<Character> reverseStack = new ArrayDeque<>();
    reverseStack.addLast(reverse.charAt(0));

    for (int i = 1; i < reverse.length(); i++) {
      char c = stack.getLast();
      if(reverse.charAt(i) == c || reverse.charAt(i) == reverse.charAt(0)) {
        stack.addLast(reverse.charAt(i));
      } else {
        reverseCnt ++;
        stack.addLast(reverse.charAt(i));
      }
    }

    System.out.println(Math.min(cnt, reverseCnt));
  }
}
