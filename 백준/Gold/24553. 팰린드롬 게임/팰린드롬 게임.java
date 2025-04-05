import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  /*
  현재 돌의 수가 펠린드론이면 이김, 자기 차례의 1자리 수면 이김.
  상윤이가 먼저 시작함. 상윤이가 이기면 0

  12 이 주어지면 펠린드롬 아님
  가장 가까운 펠린드롬 11 -> 상윤가 11빼면 1남음.
  상윤이가 2를 가져가면 10이 남음-> 무조건 1개 이상 남아서 상윤이가 이김 "0"

  27을 10으로 만들려면 17, 안되니까 20으로 만들려면 7
  그럼 20에서 9빼면 안되고 8빼면 12 하면안돼고, 1빼면 안되고 20을 만나면 또 지네

  주어진 수에서 1의 자리 혹은 10작은 수의 펠린드롬 밖에 못함.
  가장 인접한 펠린 드론이면서 남는 수가 펠린드론이 아닌 큰수?


  내 차례가 0이면 짐, 10이면 짐, 20이면 짐.. 뒷자리가 0인 숫자면 짐

  끝자리가 0으로 만드는 펠린드롬수

  주어진 수가 펠린들롬이면 상윤이김
  주어진 수에서 0으로 만드는 펠린드롬수가 있으면 상윤이가 이김
  주어진 수가 0으로 끝나는 수라면 승우가 이김

   */

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int problemNum = Integer.parseInt(br.readLine());

    while(problemNum --> 0) {

      String stoneStr = br.readLine();

      if(Long.parseLong(stoneStr) % 10 == 0) {
        System.out.println("1");
        continue;
      }

      if(isPellin(stoneStr)) {
        System.out.println("0");
        continue;
      }
    }
  }

  private static boolean isPellin(String numStr) {

    if(Long.parseLong(numStr) < 10) {
      return true;
    }

    StringBuilder sb = new StringBuilder();
    String[] str = numStr.split("");

    for(String s : str) {
      sb.append(s);
    }

    if(numStr.contentEquals(sb)) {
      return true;
    }

    return false;
  }
}
