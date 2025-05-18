import java.io.*;
import java.util.*;

public class Main {

  static int n, m, r, c, d;
  static int[][] room;    // 0 -> 청소 x , 1 -> 벽, 2 -> 청소 완료
  static int cnt = 0;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 방 크기 입력
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken()); // 로봇 i
    c = Integer.parseInt(st.nextToken()); // 로봇 j
    d = Integer.parseInt(st.nextToken()); // 방향 (0 = 12시, 1 = 9시, 2 = 6시, 3 = 3시)

    room = new int[n][m];

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < m; j++) {
        room[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    do {
      cleanMySpot();
    } while (enableToMove());

    System.out.println(cnt);
  }

  private static void cleanMySpot() {
    if(room[r][c] == 0) {
      room[r][c] = 2;
      cnt++;
    }
  }

  private static boolean enableToMove() {

    for(int i = 0; i < 4; i++) {

      d = (d + 3) % 4; // 왼쪽 방향으로 회전
      int nx = r + dx[d];
      int ny = c + dy[d];

      if (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] == 0) {
        r = nx;
        c = ny;
        return true;
      }
    }
    
    if(room[r - dx[d]][c - dy[d]] != 1) {
      r -= dx[d];
      c -= dy[d];
      return true;
    }

    return false;
  }

}
