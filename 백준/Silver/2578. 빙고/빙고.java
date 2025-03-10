import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  private static final int bingoSize = 5;

  private static HashMap<Integer, String> bingoMap = new HashMap<>();
  private static int[][] bingo = new int[bingoSize][bingoSize];

  private static int[] completeBingoRow = new int[bingoSize];
  private static int[] completeBingoCol = new int[bingoSize];
  private static int[] completeBingoCross = new int[2];

  private static StringTokenizer st;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    initCompleteBingoArr();

    for(int i = 0; i < bingoSize; i++) {
      st = new StringTokenizer(br.readLine()," ");

      for(int j = 0; j < bingoSize; j++) {
        int num = Integer.parseInt(st.nextToken());
        bingo[i][j] = num;
        bingoMap.put(num, i + "," + j);
      }
    }

    int round = 1;
    while(round < Math.pow(bingoSize, 2)) {
      st = new StringTokenizer(br.readLine()," ");

      while(st.hasMoreTokens()) {
        int num = Integer.parseInt(st.nextToken());

        String[] map = bingoMap.get(num).split(",");
        int x = Integer.parseInt(map[0]);
        int y = Integer.parseInt(map[1]);

        bingo[x][y] = 0;
        memoNumberErased(x, y);

        if(round >= 5 ) {
          if(checkBingoCompleted()) {
            System.out.println(round);
            return;
          }
        }

        round++;
      }
    }
    System.out.println("failed");
  }

  private static boolean checkBingoCompleted() {
    int count = 0;

    for(int i = 0; i < bingoSize; i++) {
      if(completeBingoRow[i] == 0) {
        count++;
      }
      if(completeBingoCol[i] == 0) {
        count++;
      }
    }

    for(int i : completeBingoCross) {
      if (i==0) count++;
    }

    return count >= 3;
  }

  private static void memoNumberErased(int row, int col) {
    completeBingoRow[row]--;
    completeBingoCol[col]--;

    if(bingoSize/2 == row && row == col) {
      completeBingoCross[0]--;
      completeBingoCross[1]--;
      return;
    }

    if(row == col) {
      completeBingoCross[0]--;
    }

    if(row + col == (bingoSize-1)) {
      completeBingoCross[1]--;
    }
  }

  private static void initCompleteBingoArr() {
    for(int i = 0; i < completeBingoRow.length; i ++) {
      completeBingoRow[i] = bingoSize;
    }
    for(int i = 0; i < completeBingoCol.length; i ++) {
      completeBingoCol[i] = bingoSize;
    }
    for(int i = 0; i < completeBingoCross.length; i ++) {
      completeBingoCross[i] = bingoSize;
    }
  }

}
