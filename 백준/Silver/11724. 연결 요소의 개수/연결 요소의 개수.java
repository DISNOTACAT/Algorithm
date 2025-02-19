import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  /*
    정점과 간선의 정보가 주어질떄 연결요소의 개수를 출력한다.
    DFS 를 사용하여 순회한다.
   */

  static HashMap<Integer, ArrayList<Integer>> graph;
  static boolean[] visited;
  static int answer = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine()," ");
    int nodes = Integer.parseInt(st.nextToken());
    int edges = Integer.parseInt(st.nextToken());

    graph = new HashMap<>();
    for(int i = 1; i <= nodes; i++){
      graph.put(i, new ArrayList<>());
    }

    for(int i = 0; i < edges; i++){
      st = new StringTokenizer(br.readLine()," ");
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph.get(start).add(end);
      graph.get(end).add(start);
    }

    visited = new boolean[nodes+1];

    for(int i = 1; i <= nodes; i++){

      if(!visited[i]){
        dfs(i);
        answer++;
      }
    }

    System.out.println(answer);
  }

  private static void dfs(int i){
    visited[i] = true;

    for(int v : graph.get(i)){
      if(!visited[v]){
        dfs(v);
      }
    }

  }
}
