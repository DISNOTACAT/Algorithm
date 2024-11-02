import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

        public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < rows; i++) {
            String s = new StringTokenizer(br.readLine()).nextToken();
            int size = s.length();

            if(size % 2 != 0) {
                System.out.println("NO");
                continue;
            }

            Deque<Character> stack = new ArrayDeque<>();

            for(int j = 0; j < size; j++) {
                if(stack.isEmpty() || stack.peekLast() == s.charAt(j)) {
                    stack.addLast(s.charAt(j));
                } else if(stack.peekLast() == '(' && s.charAt(j) == ')') {
                    stack.removeLast();
                }
            }

            if(stack.isEmpty()){
                System.out.println("YES");

            } else {
                System.out.println("NO");
            }
        }



        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
