import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    while(N --> 0) {

      String[] input = br.readLine().split(" ");
      int nodes = Integer.parseInt(input[0]);
      int edges = Integer.parseInt(input[1]);

      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for(int i = 0; i <= nodes; i++) {
        graph.add(new ArrayList<>());
      }

      // 양방향 인접그래프
      for(int i = 0; i < edges; i++) {
        String[] edge = br.readLine().split(" ");
        int start = Integer.parseInt(edge[0]);
        int end = Integer.parseInt(edge[1]);

        graph.get(start).add(end);
        graph.get(end).add(start);
      }

      System.out.println(solution(graph));
    }
  }

  private static String solution(ArrayList<ArrayList<Integer>> graph) {
    int[] colors = new int[graph.size()];
    boolean[] visited = new boolean[graph.size()];

    for (int i = 1; i < graph.size(); i++) {
        if (!visited[i]) {
            boolean result = dfs(i, 1, visited, colors, graph);
            if (!result) return "NO";
        }
    }

    return "YES";
}

private static boolean dfs(int node, int color, boolean[] visited, int[] colors, ArrayList<ArrayList<Integer>> graph) {
    visited[node] = true;
    colors[node] = color;

    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            if (!dfs(neighbor, 3 - color, visited, colors, graph)) {
                return false;
            }
        } else if (colors[neighbor] == colors[node]) {
            return false;
        }
    }

    return true;
}


}
