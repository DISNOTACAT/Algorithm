import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Set<String> set = new HashSet<>();
    int gomgom = 0;
    while(N --> 0) {

      String name = br.readLine();

      if(name.equals("ENTER")) {
        set.clear();
        continue;
      }

      if(!set.contains(name)) {
        gomgom++;
        set.add(name);
      }
    }
    System.out.println(gomgom);
  }

}
