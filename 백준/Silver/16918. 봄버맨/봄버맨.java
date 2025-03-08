import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int row;
  static int col;

  static Set<String> bombCell = new HashSet<>();
  static Set<String> allCell = new HashSet<>();

  static final int[] dx = {-1, 0, 1, 0};
  static final int[] dy = {0, 1, 0, -1};


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    row = Integer.parseInt(st.nextToken());
    col = Integer.parseInt(st.nextToken());
    int time = Integer.parseInt(st.nextToken());

    if(time % 2 == 0) {
      printAllBombMap();
      return;
    }

    for(int i = 0; i < row; i++) {
      String[] str = br.readLine().split("");

      for(int j = 0; j < col; j++) {
        String s = str[j];

        if(s.equals("O")) {
          bombCell.add(i + "," + j);
        }
      }
    }

    int curTime = 1;
    while(curTime < time) {

      Set<String> exploded = new HashSet<>();

      for(String s : bombCell) {

        String[] cur = s.split(",");

        for(int i = 0; i < 4; i++) {
          int x = Integer.parseInt(cur[0]) + dx[i];
          int y = Integer.parseInt(cur[1]) + dy[i];
          String bomb = x + "," + y;

          if(x >= 0 && x < row && y >= 0 && y < col) {
            exploded.add(bomb);
          }
        }
      }

      allCell.clear();
      for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
          String s = i + "," + j;

          if(!bombCell.contains(s) && !exploded.contains(s)) {
            allCell.add(s);
          }
        }
      }

      bombCell.clear();
      bombCell.addAll(allCell);
      curTime += 2;
    }

    printBombMap();
  }


  private static void printAllBombMap() {
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        System.out.print("O");
      }
      System.out.println();
    }
  }

  private static void printBombMap() {


    int[][] map = new int[row][col];
    Iterator<String> iter = bombCell.iterator();
    while(iter.hasNext()) {

      String[] cur = iter.next().split(",");
      int x = Integer.parseInt(cur[0]);
      int y = Integer.parseInt(cur[1]);

      map[x][y] = -1;
    }

    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        System.out.print(map[i][j] == -1 ? "O" : '.');
      }
      System.out.println();
    }
  }

}
