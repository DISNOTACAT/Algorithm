import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int rows;
  static int columns;
  static int times;

  static int[][] map;
  static int[][] tempMap;

  static int headRow = 0;
  static int bodyRow = 0;

  static int headCycleSize = 0;
  static int bodyCycleSize = 0;
  static Integer[][] headCycle;
  static Integer[][] bodyCycle;

  static final int[] dx = {1, 0, -1, 0,}; // 상 우 하 좌
  static final int[] dy = {0, 1, 0, -1};


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine(), " ");
    rows = Integer.parseInt(st.nextToken());
    columns = Integer.parseInt(st.nextToken());
    times = Integer.parseInt(st.nextToken());

    map = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      for(int j = 0; j < columns; j++){
        map[i][j] = Integer.parseInt(st.nextToken());

        if(map[i][j] == -1 && headRow == 0){
          headRow = i;
          bodyRow = i+1;
        }
      }
    }
    setHeadCycle();
    setBodyCycle();


    for(int i = 0; i < times; i++){
      updateDust();
      updateAir();
    }

    int answer = 0;
    for(int i = 0; i < rows; i++){
      for (int j = 0; j < columns; j++){
        if(map[i][j] > 0){
          answer += map[i][j];
        }
      }
    }

    System.out.println(answer);
  }

  private static void updateAir() {

    for(int i = 0; i < headCycleSize - 1; i++){
      map[headCycle[i][0]][headCycle[i][1]] = map[headCycle[i+1][0]][headCycle[i+1][1]];
    }

    for(int i = 0; i < bodyCycleSize - 1; i++){
      map[bodyCycle[i][0]][bodyCycle[i][1]] = map[bodyCycle[i+1][0]][bodyCycle[i+1][1]];
    }

    map[headRow][1] = map[bodyRow][1] = 0;

  }

  private static void updateDust() {

    int[][] tempMap = new int[rows][columns];

    for(int i = 0; i < rows; i++){
      for(int j = 0; j < columns; j++){

        if(map[i][j] >= 5) {

          int count = 0;
          int updates = map[i][j] / 5;

          for (int k = 0; k < 4; k++) {
            int nX = i + dx[k];
            int nY = j + dy[k];

            if (nX >= 0 && nX < rows && nY >= 0 && nY < columns
                && map[nX][nY] > -1) {
              tempMap[nX][nY] += updates;
              count++;
            }
          }

          map[i][j] -= (updates * count);
        }
      }
    }

    // 개별 확산 후 totalUpdates
    for(int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {

        map[i][j] += tempMap[i][j];
      }
    }
  }

  private static void setHeadCycle() {

    headCycleSize = columns*2 + headRow*2 - 2;
    headCycle = new Integer[headCycleSize][2];
    int x = headRow - 1;
    int y = 0;

    for(int i = 0; i < headCycleSize; i++) {

      headCycle[i][0] = x;
      headCycle[i][1] = y;

      if(map[x][y] == -1){
        break;
      }

      if(y == 0 && x > 0) {
        x--;

      } else if (x == 0 && y < columns - 1) {
        y++;

      } else if (y == columns - 1 && x < headRow) {
        x++;

      } else if (x == headRow && y > 0) {
        y--;

      } else {
        throw new IndexOutOfBoundsException("Head cycle out of bounds");
      }
    }

  }

  private static void setBodyCycle() {

    bodyCycleSize = columns*2 + (rows - bodyRow)*2 - 4;
    bodyCycle = new Integer[bodyCycleSize][2];

    int x = bodyRow + 1;
    int y = 0;

    for(int i = 0; i < bodyCycleSize; i++) {

      bodyCycle[i][0] = x;
      bodyCycle[i][1] = y;

      if(map[x][y] == -1){
        break;
      }

     if(y == 0 && x < rows - 1) {
        x++;

      } else if (x == rows - 1 &&  y < columns - 1) {
        y++;

      } else if (y == columns - 1 && x > bodyRow) {
        x--;

      } else if (x == bodyRow && y < columns) {
        y--;

      } else {
        throw new IndexOutOfBoundsException("Body cycle out of bounds");
      }
    }

  }

}
