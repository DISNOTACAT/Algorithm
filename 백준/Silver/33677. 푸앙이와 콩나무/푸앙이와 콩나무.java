import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

  private static class Node implements Comparable<Node> {
    int height;
    int water;
    int day;

    public Node(int height, int water, int day) {
      this.height = height;
      this.water = water;
      this.day = day;
    }

    @Override
    public int compareTo(Node o) {
      return this.height - o.height;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(N, 0, 0)); // height, water,day

    int[] visited = new int[N+1];
    Arrays.fill(visited, Integer.MAX_VALUE);

    int answerDay = Integer.MAX_VALUE;
    int answerWater = Integer.MAX_VALUE;

    while(!pq.isEmpty()) {
      Node curNode = pq.poll();

      if(curNode.height < 0) continue; // 범위를 벗어나면 패스
      if(curNode.day > visited[curNode.height]) continue; // 이전 방문보다 깊은 방문이면 패스

      visited[curNode.height] = curNode.day; // 방문 기록

      if(curNode.height == 0) {
        if(curNode.day == answerDay && curNode.water >= answerWater) continue;

        answerDay = curNode.day;
        answerWater = curNode.water;
        continue;
      }

      // 다음 경우의 노드 저장
      pq.offer(new Node(curNode.height-1, curNode.water+1, curNode.day+1));

      if(curNode.height % 3 == 0) {
        pq.offer(new Node(curNode.height/3, curNode.water+3, curNode.day+1));
      }

      int sqrt = (int) Math.sqrt(curNode.height);
      if(sqrt * sqrt == curNode.height) {
        pq.offer(new Node(sqrt, curNode.water + 5, curNode.day+1));
      }
    }

    System.out.println(answerDay + " " + answerWater);
  }

}
