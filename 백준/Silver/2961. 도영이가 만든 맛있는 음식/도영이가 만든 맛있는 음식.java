import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int countFoods = Integer.parseInt(br.readLine());
    String[] foods = new String[countFoods];

    for(int i = 0; i < countFoods; i++){
      foods[i] = br.readLine();
    }

    for(int i = 0; i < countFoods; i++){
      cook(i, foods, 1L, 0L);
    }

    System.out.println(answer);
  }

  private static void cook(int fixedIndex, String[] foods, long curSour, long curBitter) {

    String[] taste = foods[fixedIndex].split(" ");
    long sour = Long.parseLong(taste[0]) * curSour;
    long bitter = Long.parseLong(taste[1]) + curBitter;

    answer = (int) Math.min(answer, Math.abs(sour - bitter));

    for(int i = fixedIndex + 1; i < foods.length; i++){
      cook(i, foods, sour, bitter);
    }
  }

}
