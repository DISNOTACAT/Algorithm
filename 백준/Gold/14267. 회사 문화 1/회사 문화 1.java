import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] praise = new int[n+1];

    int[] boss = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    ArrayList<Integer>[] tree = new ArrayList[n+1];
    for(int i = 0; i <= n; i++) {
      tree[i] = new ArrayList<>();
    }

    for(int i = 0; i < n; i++) {
      int myBoss = boss[i];
      if(myBoss == -1) continue;

      tree[myBoss].add(i+1);
    }

    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int num = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      praise[num] += p;
    }

    for(int i = 1; i <= n; i++) {
      ArrayList<Integer> myJuniors = tree[i];
      for(int j = 0; j < myJuniors.size(); j ++) {
        praise[myJuniors.get(j)] += praise[i];
      }
    }

    for(int i = 1; i <= n; i++) {
      System.out.print(praise[i] + " ");
    }

  }

}
