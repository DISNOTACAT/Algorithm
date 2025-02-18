import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    for(int i = 1; i <= N; i++){
      graph.put(i, new ArrayList<>());
    }

    for(int i = 0; i < N - 1; i++){
      String[] line = br.readLine().split(" ");
      int start = Integer.parseInt(line[0]);
      int end = Integer.parseInt(line[1]);

      graph.get(start).add(end);
      graph.get(end).add(start);
    }

    int[] answer = new int[N + 1];

    dfs(1, graph, answer, new boolean[N+1]);

    for(int i = 2; i <= N; i++){
      System.out.println(answer[i]);
    }
  }

  private static void dfs(int cur, HashMap<Integer, ArrayList<Integer>> graph, int[] answer, boolean[] visited){
    visited[cur] = true;

    for(int i : graph.get(cur)){
      if(!visited[i]){
        answer[i] = cur;
        dfs(i, graph, answer, visited);
      }
    }
  }
}
