import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  private static List<ArrayList<Integer>> graph;
  private static int[] indegree;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int problemCount = Integer.parseInt(st.nextToken());
    int nodeCount = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    for(int i = 0; i <= problemCount; i++){
      graph.add(new ArrayList<>());
    }
    indegree = new int[problemCount+1]; // 위상정렬을 위한 연결 간선 수.
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // 먼저 풀기하할 순서를 정하는 큐

    for(int i = 1; i <= nodeCount; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int pre = Integer.parseInt(st.nextToken());
      int post = Integer.parseInt(st.nextToken());
      graph.get(pre).add(post);
      indegree[post]++;
    }

    // 연결된 문제가 없는 문제 번호를 pq에 넣는다. (이후 pq에 있느 번호들: 연결되지 않은 단일 번호 and pre)
    for(int i = 1; i <= problemCount; i++){
      if(indegree[i] == 0){
        pq.offer(i);
      }
    }

    while (pq.size() > 0){ // pq에서 꺼내서 하나씩 bfs를 돌린다. (가능한 작은 수를 풀기위함)

      int cur = pq.poll();
      System.out.print(cur + " "); // 문제를 푼다!

      for(int i = 0; i < graph.get(cur).size(); i++) {
        int post = graph.get(cur).get(i);
        indegree[post]--;

        if(indegree[post] == 0){
          pq.offer(post);
        }
      }
    }
  }
}
