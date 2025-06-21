import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

  /*
  0 인 부분을 BFS 순회하며, 1인 부분의 visited를 확인
  1에 막혀서 들어가지 못하는 안쪽은 확인하지 않을 거임
  visited 가 2라면 1시간 뒤에 녹음

  2인 곳을 0으로 만들고 visited 초기화
  반복
   */

  private static int[] dx = {-1, 0, 1, 0};
  private static int[] dy = {0, 1, 0, -1};

  private static int N;
  private static int M;
  private static int[][] map;
  private static Queue<int[]> cheeseQue = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    N = size[0];
    M = size[1];

    map = new int[N][M];
    for(int i = 0; i < N; i++) {
      map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    int hour = 0;
    int emptyCount = 0;

    while(emptyCount < (N*M)) {

      boolean[][] visited = new boolean[N][M];
      emptyCount = bfs(visited, 0, 0);

      if(cheeseQue.isEmpty()) break;
      updatedCheese(cheeseQue);
      hour++;
    }

    System.out.println(hour);
  }

  private static void updatedCheese(Queue<int[]> cheeseQue) {

    int[][] newMap = new int[N][M];

    while(!cheeseQue.isEmpty()) {
      int[] cheese = cheeseQue.poll();
      int x = cheese[0];
      int y = cheese[1];

      newMap[x][y]++;
      if(newMap[x][y] == 2 && map[x][y] == 1) {
        map[x][y] = 0;
      }
    }
  }

  private static int bfs(boolean[][] visited, int x, int y) {

    if(x < 0 || x >= N || y < 0 || y >= M || visited[x][y]) return 0;

    if(map[x][y] != 0) {
      cheeseQue.add(new int[]{x, y});
      return 0;
    }

    visited[x][y] = true;

    int count = 0;

    for(int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      count +=  bfs(visited, nx, ny);
    }

    return count + 1;
  }

}
