import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> num = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
        .collect(Collectors.toList());
    int[] game = new int[num.get(0)];

    for(int i = 0; i < game.length; i++){
      game[i] = Integer.parseInt(br.readLine());
    }

    int death = 0;
    int count = 0;
    while(death != num.get(1)){

      if(death == -1){
        count = -1;
        break;
      }

      int next = game[death];
      game[death] = -1;
      death = next;
      count++;
    }

    System.out.println(count);
  }

}
