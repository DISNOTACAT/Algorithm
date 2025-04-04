import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  /*
  늑대랑 양이 인접하다면 0을 출력한다.
  늑대가 없다면 무조건 1을 출력한다.
  제한이 없으니 빈칸에는 모두 울타리를 출력한다.
   */

  private final static String SHEEP = "S";
  private final static String WOLF = "W";
  private final static String DEFENCE = "D";

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int row = Integer.parseInt(st.nextToken());
    int column = Integer.parseInt(st.nextToken());

    String[][] farm = new String[row][column];
    Deque<String> sheepQue = new ArrayDeque<>();

    int wolfCount = 0;
    for(int i = 0; i < row; i++){

      String[] inputRow = br.readLine().split("");

      for(int j = 0; j < column; j++) {
        String input = inputRow[j];

        if(input.equals(SHEEP)) {
          sheepQue.offer(i + " " + j);
        }

        if(input.equals(WOLF)) {
          wolfCount++;
        }

        if(input.equals(".")) {
          inputRow[j] = DEFENCE;
        }

        farm[i] = inputRow.clone();
      }
    }

    if(wolfCount != 0 && noWayToBeSafe(farm, sheepQue)) {
      System.out.println(0);
      return;
    }

    System.out.println(1);
    for(int i = 0; i < row; i++) {
      for(String s : farm[i]) {
        System.out.print(s);
      }
      System.out.print("\n");
    }
  }

  private static boolean noWayToBeSafe(String[][] farm, Deque<String> sheepQue) {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    while(!sheepQue.isEmpty()) {

      String[] sheepLocation = sheepQue.poll().split(" ");
      int sheepRow = Integer.parseInt(sheepLocation[0]);
      int sheepColumn = Integer.parseInt(sheepLocation[1]);

      for(int i = 0; i < 4; i++) {

        if(sheepRow + dx[i] >= 0 && sheepRow + dx[i] < farm.length && sheepColumn + dy[i] >= 0 && sheepColumn + dy[i] < farm[0].length &&
            farm[sheepRow+dx[i]][sheepColumn+dy[i]].equals(WOLF)) {
          return true;
        }
      }
    }
    return false;
  }
}
