import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    double[] drinks = new double[N];

    String[] drinkStr = br.readLine().split(" ");
    for(int i = 0; i < N; i++){
      drinks[i] = Integer.parseInt(drinkStr[i]);
    }

    Arrays.sort(drinks);

    double energyResult = drinks[drinks.length-1];
    for(int i = 0; i < drinks.length-1; i++){

      energyResult = mix(drinks[i], energyResult);
    }

    System.out.println(energyResult);
  }

  private static double mix(double small, double big) {

    return (small /2) + big;
  }

}
