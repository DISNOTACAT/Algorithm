import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static int[][] team;
  private static int min = Integer.MAX_VALUE;
  private static int totalTeamCount = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    totalTeamCount = Integer.parseInt(br.readLine());
    StringTokenizer st;

    generateTeamPoint(totalTeamCount, br);

    int cases = (int) Math.pow(2, totalTeamCount);

    for(int i = 1; i < cases; i++) {

      if(min == 0) {
        break;
      }

      int powerOfCase = calculateTeamPower(i);
      if(powerOfCase >= 0) {
        min = Math.min(min, powerOfCase);
      }
    }

    System.out.println(min);
  }

  private static int calculateTeamPower(int cases) {

    if(Integer.bitCount(cases) < 2) {
      return -1;
    }


    int[] teamNumberArr = generateTeamNumberArr(cases);
    int[] teamPower = new int[2];

    for(int player = 0; player < teamNumberArr.length; player++) {
      int teamNumber = teamNumberArr[player];

      for(int otherPlayer = player +1; otherPlayer < teamNumberArr.length; otherPlayer++) {

        if(teamNumber == teamNumberArr[otherPlayer]) {

          int power = team[player][otherPlayer] + team[otherPlayer][player];
          teamPower[teamNumber] += power;
        }
      }
    }

    return Math.abs(teamPower[0] - teamPower[1]);
  }

  private static int[] generateTeamNumberArr(int cases) {
    String binaryString = Integer.toBinaryString(cases);
    String binaryTeamResult = "";

    if(binaryString.length() < totalTeamCount) {
      String zeroSpace = "0".repeat(totalTeamCount - binaryString.length());
      binaryTeamResult = zeroSpace + binaryString;
    } else {
      binaryTeamResult = binaryString;
    }

    return Arrays.stream(binaryTeamResult.split(""))
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  private static void generateTeamPoint(int N, BufferedReader br) throws IOException {
    StringTokenizer st;
    team = new int[N][N];
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine(), " ");
      for(int j = 0; j < N; j++){
        team[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

}
