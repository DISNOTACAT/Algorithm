import java.util.*;

class Solution {

  static boolean[] visit;

  public static int solution(int n, int[][] computers) {

    visit = new boolean[n];
    int count = 0;

    for(int i = 0; i < n; i++) { // 각 노드마다 순회

      if(!visit[i]) {
        dfs(computers, i);
        count++;
      }
    }

    return count;

  }

  public static void dfs(int[][] computers, int i) {

    // i 번 컴퓨터에 연결된 컴퓨터 체크
    visit[i] = true;

    for(int j = 0; j < computers[i].length; j++) {
      if(computers[i][j] == 1 && !visit[j]) {
        dfs(computers, j);
      }
    }
  }
  
}