import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  private static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    st = new StringTokenizer(br.readLine()," ");
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    String DNA = br.readLine();

    st = new StringTokenizer(br.readLine()," ");
    int a = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int g = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    br.close();


    int result = 0;
    int left = 0;
    int right = 0;

    Map<Character , Integer> map = new HashMap<>();
    map.put('A', 0);
    map.put('C', 0);
    map.put('G', 0);
    map.put('T', 0);


    while(right <= S){

      if((right - left) == P) {

        if (map.get('A') >= a
            && map.get('C') >= c
            && map.get('G') >= g
            && map.get('T') >= t) {

          result++;
        }

        if(map.get(DNA.charAt(left)) > 0) {
          map.put(DNA.charAt(left), map.getOrDefault(DNA.charAt(left), 0) - 1);
        }
        left++;

      }

      if(right == S) break;

      map.put(DNA.charAt(right), map.getOrDefault(DNA.charAt(right), 0) + 1);
      right++;

    }

    System.out.println(result);

  }
  
  public static void main(String[] args) throws IOException {
    solution();
  }

}
