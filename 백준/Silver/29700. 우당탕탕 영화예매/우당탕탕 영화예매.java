import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  /*
    N : 영화관 세로줄
    M : 영화관 가로줄
    K : 연달아 앉을 칸의 수

    0 -> 빈 좌석
    1 -> 예약된 좌석

    K 명이 가로로 연달아 앉을 수 있는 방법의 수

    K = 3
    1 1 0 0 0
    0 1 0 1 0
    1 0 0 0 0

    1열에서 연달아 0이 나오는 곳이 1회
    2열에서 0 회
    3열에서 234 / 235 2회
    총 3회

    왼쪽에서 부터 K 구간의 합이 0인 횟수를 찾는다
   */

  private static void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] cinema = new int[N][M];

    for(int i = 0; i < N; i++) {
      String line = br.readLine();
      for(int j = 0; j < M; j++) {
        cinema[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
      }
    }

    int count = 0;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M; j++) {

        if(cinema[i][j] == 0 && (j+K) <= M) {

          int sum = 0;
          for(int k = 0; k < K; k++) {

            sum += cinema[i][j+k];
          }

          if(sum == 0) count++;
        }
      }
    }
    System.out.println(count);
  }


  public static void main(String[] args) throws IOException {

    solution();
  }

}
