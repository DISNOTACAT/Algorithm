
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<String> list = new ArrayList<>();
    List<String> answer = new ArrayList<>();

    for(int i = 0; i < N + M; i++) {
      list.add(br.readLine());
    }

    Collections.sort(list);

    for(int i = 1; i < N + M; i++) {
      if(list.get(i).equals(list.get(i - 1))) {
        answer.add(list.get(i));
        i++;
      }
    }

    System.out.println(answer.size());
    for(String name : answer) {
      System.out.println(name);
    }
  }
}
