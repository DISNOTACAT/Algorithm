import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    TreeMap<String, Integer> map = new TreeMap<>();
    int max = 0;


    int n = Integer.parseInt(br.readLine());
    for(int i = 0; i < n; i++){
      String s = br.readLine();
      map.put(s, map.getOrDefault(s, 0) + 1);

      if(map.get(s) > max){
        max = map.get(s);
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for(Entry<String, Integer> entry : map.entrySet()){
      if(entry.getValue() == max){
        bw.write(entry.getKey());
        break;
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }

}
