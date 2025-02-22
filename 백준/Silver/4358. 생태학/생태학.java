import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

  static int total = 0;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    TreeMap<String, Integer> map = new TreeMap<>();
    String s;

    while((s = br.readLine()) != null && !s.isEmpty()) {
      map.put(s, map.getOrDefault(s, 0) + 1);
      total++;
    }

    br.close();

    for(Entry<String, Integer> val : map.entrySet()){
      System.out.printf("%s %.4f%n", val.getKey(), (val.getValue() * 100.0) / total);
    }
  }

}
