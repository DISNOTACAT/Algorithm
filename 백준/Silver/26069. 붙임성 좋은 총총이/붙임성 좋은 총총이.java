import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Set<String> dancing = new HashSet<>();
    dancing.add("ChongChong");
    
    while(n --> 0) {

      String[] str = br.readLine().split(" ");

      if(dancing.contains(str[0]) || dancing.contains(str[1])) {
        dancing.add(str[0]);
        dancing.add(str[1]);
      }

    }
    System.out.println(dancing.size());
  }

}
