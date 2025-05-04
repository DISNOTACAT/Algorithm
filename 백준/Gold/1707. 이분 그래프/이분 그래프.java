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

    for (int start = 1; start < graph.size(); start++) {
        if (visited[start]) continue;

        Deque<Integer> que = new ArrayDeque<>();
        que.add(start);
        colors[start] = 1;

        while (!que.isEmpty()) {
            int node = que.pollFirst();
            visited[node] = true;

            for (Integer neighbor : graph.get(node)) {
                if (colors[neighbor] != 0) {
                    if (colors[neighbor] == colors[node]) {
                        return "NO";
                    }
                    continue;
                }

                colors[neighbor] = (colors[node] == 1 ? 2 : 1);
                que.addLast(neighbor); // BFS
            }
        }
    }

    return "YES";
}

}
