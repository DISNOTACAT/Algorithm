
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    solution();
  }

  public static int solution1() throws IOException {

    /*
      빗물이 차지 못하는 직사각형을 찾는다.
      빗물 = 전체 너비 - 블럭 - 빗물이 못차는 상단

      현재 자리에서 옆으로 이동하며, 나보다 더 높은 블럭을 찾는다.
      또는 옆의 기둥의 높이를 갱신해 가며 이전보다 작은 높이의 기둥을 만나면 그사이를 계산한다.

      1번 경우
      0번째 3높이 ~ 3번째 4높이 사이 구간
      3-0 = 3 -> 가로
      4-3 = 1 -> 세로
      즉, 3*1 = 3
      빗물 = 16 - 8 - 3 = 5

      2번 경우
      0번째 높이 3
      그다음, 1 - 2  - 3 - 4 (현재 나보다 큼)
      4-0 = 4
      4-3 = 1  --> 첫 빗물 -4
      4번째 높이 4에서 다시 출발
      그다음, 1 - 1 - 2 - 0 (이전값보다 작음-> 이전값 2와 비교)
      7-4 = 3
      4-2 = 2 ---> 두번째 빗물 -6
      빗물 = 32 - 17 - 4 - 6 = 5

      3번 경우
      시작 기둥이 0인 경우 높은 기둥 찾기는 제외한다.
      시작 0 - 0 - 0 - 2 - 0 (이전보다 작아짐 시작점)
      2일때와 마지막 의 차이는 1이 때문에 제외한다.
      빗물의 값을 전혀 구하지 못한경우, 빗물 = 0

     */


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int area = h * w;


    // 총 블럭 갯수
    int[] block = new int[w + 1];

    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < w; i++){
      block[i] = Integer.parseInt(st.nextToken());
    }

    // 초기값 설정
    int height = block[0];
    int startIndex = 0;
    int total = height;

    int space = 0;
    int max = height;

    for(int i = 1; i < w; i++){
      total += block[i];

      // 가장 높은 기둥 찾기
      if(block[i] > max){
        max = block[i];
      }

      // 만약 초기값 기둥이 0이라면 기둥을 갱신할 때 까지 계속한다,
      if(height == 0 && block[i] > 0) {
        space += h;
        height = block[i];
        startIndex = i;
        continue;
      }

      if(block[i] > height && i - startIndex > 1){
      // 만약 다음 기둥이 초기값보다 크면 계산한다.
        space += ((i-startIndex) * (block[i] - height));
        height = block[i];
        startIndex = i;

      } if(block[i] > block[i+1] && i - startIndex > 1){
      // 만약 다음 기둥이 직전 기둥보다 작다면 계산한다.
        space += ((i-startIndex) * (height - block[i]));
        height = block[i];
        startIndex = i;
      }
    }

    if(space == 0) {
      return 0;
    }

    if(max < h){
      space += (h - max) * w;
    }

    return (area - total - space);
  }

  public static void solution() throws IOException {

    /*
      이차원 배열로 만들어서 한줄 씩 검토한다.
      4 4
      3 0 1 4
      [1, 0, 1, 1]
      [1, 0, 0, 1]
      [1, 0, 0, 1]
      [0, 0, 0, 1]
      위에서부터 그냥 채우고 1과 1 사이의 값들을 찾으면 됨
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());


    int[] block = new int[w + 1];
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 1; i < w + 1; i++){
      block[i] = Integer.parseInt(st.nextToken());
    }

    int[][] map = new int[h][w + 1];
    for(int i = 0; i < h; i++){
      for(int j = 1; j < w + 1; j++){
        if(block[j] > 0){
          block[j]--;
          map[i][j] = 1;
        }
      }
    }

    int rain = 0;

    for(int i = 0; i < h; i++){

      int start = 0;
      int end = 0;
      for(int j = 1; j <= w; j++){

        if(map[i][j] == 1){

          if(start == 0) {
            start = j;
          } else  if(end  == 0) {
            end = j;
            rain += (end - start - 1);
          } else {
            start = j;
            rain += (start - end - 1);
            end = 0;
          }
        }
      }
    }

    System.out.println(rain);
  }
}
