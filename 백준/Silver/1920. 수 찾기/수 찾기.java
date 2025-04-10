import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());


    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    HashMap<Integer, Integer> map = new HashMap<>();
    while(st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());
      map.put(num, 1);
    }
    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    while(M --> 0) {
      int num = Integer.parseInt(st.nextToken());
      if(map.containsKey(num)) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }

}
