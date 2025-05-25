import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  private static int row;
  private static int colum;
  private static int[][] map;

  private static int[] dx = {1, -1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");

    row = Integer.parseInt(str[0]);
    colum = Integer.parseInt(str[1]);

    map = new int[row][colum];

    for(int i = 0; i < row; i++) {
      String input = br.readLine();
      for(int j = 0; j < colum; j++) {
        map[i][j] = input.charAt(j) - '0';
      }
    }

    System.out.println(solution());
  }

  private static int solution() {

    Deque<int[]> visitedQue = new ArrayDeque<>();
    visitedQue.addLast(new int[]{0,0,0});

    int[][][] visited = new int[row][colum][2];
    visited[0][0][0] = 1;

    while (!visitedQue.isEmpty()) {
      int[] poll = visitedQue.pollFirst();
      int cx = poll[0];
      int cy = poll[1];
      int broken = poll[2];

      if(cx == (row - 1) && cy == (colum - 1)) return visited[cx][cy][broken];

      for (int i = 0; i < 4; i++) {

        int nx = cx + dx[i];
        int ny = cy + dy[i];

        if (nx < 0 || ny < 0 || nx >= row || ny >= colum) continue; // 범위를 벗어나는 경우

        // 벽이 아닌 경우 -> 저장
        if (map[nx][ny] == 0 && visited[nx][ny][broken] == 0) {
          visitedQue.addLast(new int[]{nx, ny, broken});
          visited[nx][ny][broken] = visited[cx][cy][broken] + 1;
        }

        // 벽인 경우 -> 아직 벽을 안 부숨 && 현재 벽도 부순 적 없음
        if (map[nx][ny] == 1 && broken == 0 && visited[nx][ny][1] == 0) {
          visitedQue.addLast(new int[]{nx, ny, 1});
          visited[nx][ny][1] = visited[cx][cy][broken] + 1;
        }
      }
    }
    return -1;
  }
}
