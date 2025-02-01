import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    solution();
  }

  private static void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int size = Integer.parseInt(br.readLine());
    StringTokenizer st;

    int[][] map = new int[size + 1][size + 1];
    for(int i = 1; i < size + 1; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      for(int j = 1; j < size + 1; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    /*
    백트래킹?
    -1 직전에서 갈수 있는 방법 찾기
     */

    String fail = "Hing";
    String success = "HaruHaru";

    for(int i = size; i > 0; i--){
      for(int j = size; j > 0; j--){

        if(map[i][j] == -1) {

          if(j > 1) {

            for(int k = j - 1; k > 0; k--){
              if(map[i][k] == (j - k)) {
                map[i][k] = -1;
              }
            }
          }

          if(i > 1) {

            for(int k = i - 1; k > 0; k--){
              if(map[k][j] == (i - k)) {
                map[k][j] = -1;
              }
            }
          }
        }

      }
    }

    if(map[1][1] == -1) {
      System.out.println(success);
    } else {
      System.out.println(fail);
    }

  }
}
