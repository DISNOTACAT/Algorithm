import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] arr = new int[N][N];
    for(int i = 0; i < N; i++) {
      String[] str = br.readLine().split(" ");
      for(int  j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(str[j]);
      }
    }

    for(int k = 0; k < N; k++){
      for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++) {
          if(arr[i][k] == 1 && arr[k][j] == 1) {
            arr[i][j] = 1;
          }
        }
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < N; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}
