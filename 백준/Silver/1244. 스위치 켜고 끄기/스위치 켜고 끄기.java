import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int switchCount = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] switches = new int[switchCount + 1];
    for(int i = 1; i <= switchCount; i++) {
      switches[i] = Integer.parseInt(st.nextToken());
    }

    int studentCount = Integer.parseInt(br.readLine());
    while(studentCount --> 0) {

      st = new StringTokenizer(br.readLine(), " ");
      String gender = st.nextToken();
      int switchNumber = Integer.parseInt(st.nextToken());

      if(gender.equals("1")) {
        switches = switchChangedByBoy(switches, switchNumber);
        continue;
      }

      if(gender.equals("2")) {
        switches = switchChangedByGirl(switches, switchNumber);
        continue;
      }

      throw new IllegalArgumentException("잘못된 입력값입니다.");
    }

    for(int i = 1; i <= switchCount; i++) {
      System.out.print(switches[i] + " ");
      if(i % 20 == 0) {
        System.out.println();
      }
    }

  }

  private static int[] switchChangedByGirl(int[] switches, int switchNumber) {

    switches[switchNumber] = getReverseStatus(switches[switchNumber]);

    int left = switchNumber - 1;
    int right = switchNumber + 1;

    while(left > 0 && right < switches.length) {

      if(switches[left] == switches[right]) {
        switches[left] = getReverseStatus(switches[left]);
        switches[right] = getReverseStatus(switches[right]);
      } else {
        break;
      }
      left--;
      right++;
    }


    return switches;
  }

  private static int[] switchChangedByBoy(int[] switches, int switchNumber) {

    int changingSwitchNumber = switchNumber;
    while(changingSwitchNumber < switches.length) {

      int originStatus = switches[changingSwitchNumber];
      switches[changingSwitchNumber] = getReverseStatus(originStatus);

      changingSwitchNumber += switchNumber;
    }

    return switches;
  }

  private static int getReverseStatus(int originStatus) {

    if(originStatus == 1) {
      return 0;
    }
    return 1;
  }
}
