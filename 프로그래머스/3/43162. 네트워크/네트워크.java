import java.util.*;

class Solution {
  public int solution(int n, int[][] computers) {

    ArrayList<Integer>[] list = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      list[i] = new ArrayList<>();
    }

    for(int i = 0; i < computers.length; i++) {

      for (int j = 0; j < computers[i].length; j++) {

        if (computers[i][j] == 1) {
          list[i].add(j);
        }
      }
    }

    boolean visit[] = new boolean[computers.length];
    int count = 0;


    for(int i = 0; i < computers.length; i++) { // 각 노드마다 순회

      if(visit[i]) continue;  // 이전에 연결 확인한 노드면 패스

      Queue<Integer> queue = new LinkedList<>();
      queue.add(list[i].get(0));
      count++;

      while(!queue.isEmpty()) { // 연결된 곳들을 순회

        int current = queue.poll();
        visit[current] = true;

        if(list[current].isEmpty()) continue; // 리프 노드면 패스

        for(int j = 0; j < list[current].size(); j++) {
          if(!visit[list[current].get(j)]) {
            queue.add(list[current].get(j));
          }
        }
      }
    }
    return count;

  }
}