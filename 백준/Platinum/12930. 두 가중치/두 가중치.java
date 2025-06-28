import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

  private static int N;
  private static int[][] graph1;
  private static int[][] graph2;

  private static class Node implements Comparable<Node> {
    private int nodeNum;
    private int cost;
    private int otherCost;

    public Node(int nodeNum, int cost, int otherCost) {
      this.nodeNum = nodeNum;
      this.cost = cost;
      this.otherCost = otherCost;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    // 가중치 그래프 입력
    graph1 = new int[N][N];
    graph2 = new int[N][N];

    for(int i = 0; i < (N*2); i++) {
      char[] input = br.readLine().toCharArray();

      for(int j = 0; j < N; j++) {
        int n = input[j] - '0';
        if(n > 0 && n < 10){

          if(i < N) {
            graph1[i][j] = n;
          } else {
            graph2[i % N][j % N] = n;
          }
        }
      }
    }

    int answer = Math.min(dijkstra(graph1, graph2), dijkstra(graph2, graph1));
    System.out.println(answer);
  }

  private static int dijkstra(int[][] graph1, int[][] graph2) {
    PriorityQueue<Node> pq = new PriorityQueue<>(); // 0번에서 각 노드로 이동하면서 담는다.
    boolean[] visited = new boolean[N];
    int[] dist1 = new int[N];
    int[] dist2 = new int[N];
    Arrays.fill(dist1, Integer.MAX_VALUE);
    Arrays.fill(dist2, Integer.MAX_VALUE);

    pq.offer(new Node(0,0,0)); // 0번 노드에 연결된 간선을 pq에 담는다

    // 모든 간선에 방문하며 최소값을 갱신
    while(!pq.isEmpty()) {

      Node startNode = pq.poll();
      int startNodeNum = startNode.nodeNum;

      if(visited[startNodeNum]) continue;

      visited[startNodeNum] = true;
      for(int nextNodeNum = 0; nextNodeNum < N; nextNodeNum++) {

        if(graph1[startNodeNum][nextNodeNum] == 0) continue; // 간선이 없다면 continue

        int nextCost = startNode.cost + graph1[startNodeNum][nextNodeNum];

        if(dist1[nextNodeNum] > nextCost) {
          dist1[nextNodeNum] = nextCost;
          int otherCost = startNode.otherCost + graph2[startNodeNum][nextNodeNum];
          dist2[nextNodeNum] = otherCost;

          pq.offer(new Node(nextNodeNum, nextCost, otherCost));
        }
      }
    }

    if(dist1[1] == Integer.MAX_VALUE) return -1;

    return dist1[1] * dist2[1];
  }

}
