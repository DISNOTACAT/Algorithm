import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static final int LAST_SEAT = (1 << 20) - 1;
  private static ArrayList<Integer> trains = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputStr = br.readLine().split(" ");

    int n = Integer.parseInt(inputStr[0]);
    for(int i = 0; i < n; i++) {
      trains.add(0);
    }

    int m = Integer.parseInt(inputStr[1]);
    while(m --> 0) {
      String[] commandLine = br.readLine().split(" ");
      int command = Integer.parseInt(commandLine[0]);
      int trainNum = Integer.parseInt(commandLine[1]) - 1;

      switch(command) {
        case 1 -> plus(trainNum, Integer.parseInt(commandLine[2]));
        case 2 -> minus(trainNum, Integer.parseInt(commandLine[2]));
        case 3 -> moveBack(trainNum);
        case 4 -> moveFront(trainNum);
        default -> throw new IllegalArgumentException("Invalid command");
      }
    }

    Set<Integer> answer = new HashSet<>();
    for(Integer i : trains) {
      answer.add(i);
    }

    System.out.println(answer.size());
  }

  private static void plus(int trainNum, int seat) {
    int getTrain = trains.get(trainNum);
    trains.set(trainNum, getTrain | (1<<(seat-1)));
  }

  private static void minus(int trainNum, int seat) {
    int getTrain = trains.get(trainNum);
    // 빼려는 자리에 사람이 있는 경우
    if((getTrain & (1<<(seat-1))) > 0) {
      trains.set(trainNum, getTrain - (1<<(seat-1)));
    }
  }

  private static void moveBack(int trainNum) {
    int temp= trains.get(trainNum)<<1;
    if(temp > LAST_SEAT) {
      temp -= (1<<20);
      trains.set(trainNum, temp);
    } else {
      trains.set(trainNum, temp);
    }
  }

  private static void moveFront(int trainNum) {
    trains.set(trainNum, trains.get(trainNum)>>1);
  }

}
