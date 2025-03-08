import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());

    int row = 1;
    while(x >= row) {
      x = x-row;
      row++;
    }

    if(x == 0) {
      System.out.println(getByIndex(row-1, row-1));
    } else {
      System.out.println(getByIndex(x, row));
    }
  }

  private static String getByIndex(int index, int row) {
    String[] fractions = new String[row];

    for(int i = 0; i < row; i++) {
      int numerator = i + 1;
      int denominator = row - i;
      fractions[i] = numerator + "/" + denominator;
    }

    // 짝수면 뒤에서 시작함
    if(row % 2 == 0) {
      return fractions[index-1];
    }

    return fractions[fractions.length - index];
  }

}
