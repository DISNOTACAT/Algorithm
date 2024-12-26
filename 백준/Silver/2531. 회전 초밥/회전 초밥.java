import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  private static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    st = new StringTokenizer(br.readLine()," ");
    int N = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] belt = new int[N];
    for(int i = 0; i < N; i++){
      belt[i] = Integer.parseInt(br.readLine());
    }

    br.close();

    int max = 0;
    int startIndex = 0; // 0부터 N 까지 진행
    int endIndex = k-1; // (k-1) 부터 (k-2) 까지

    Set<Integer> set = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();

    // 첫 구간 초기화
    for(int i = 0; i <= endIndex; i++){
      set.add(belt[i]);
      map.put(belt[i], map.getOrDefault(belt[i], 0) + 1);
    }


    while(startIndex < N){  // 시작점이 한바퀴를 돌면 종료

      // 최대 경우의 수를 set 사이즈로 갱신
      if(max <= set.size()) {

        if(set.contains(c)) {
          max = set.size();
        } else {
          max = set.size() + 1; // 벨트에 쿠폰 초밥이 없다면 ++
        }
      }

      // 최고의 값 여부 확인
      if(set.size() == k && !set.contains(c)) {
        max = k+1;
        break;
      }

      // 다음 칸으로 이동
      // 1. 시작 한칸 삭제
      if(map.get(belt[startIndex]) == 1){
        set.remove(belt[startIndex]);
      }
      map.put(belt[startIndex], map.get(belt[startIndex]) - 1);

      // 2. 뒷칸 추가
      startIndex++;
      endIndex = (startIndex + k - 1) % N;
      map.put(belt[endIndex], map.getOrDefault(belt[endIndex], 0) + 1);
      set.add(belt[endIndex]);
    }
    System.out.println(max);

  }

  public static void main(String[] args) throws IOException {
    solution();
  }

}
