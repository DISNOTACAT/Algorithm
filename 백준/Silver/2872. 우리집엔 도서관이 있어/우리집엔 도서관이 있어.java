import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int bookCount = Integer.parseInt(br.readLine());

    int[] bookArr = new int[bookCount];
    for(int i = 0; i < bookCount; i++) {
      bookArr[i] = Integer.parseInt(br.readLine());
    }

    int result = 0;
    int targetBookNum = bookCount;
    int index = bookCount-1;


    while(index >= 0) {

      if(bookArr[index] == targetBookNum) {
        targetBookNum--;
        continue;
      }

      if(bookArr[index] < targetBookNum ){
        result++;
      }
      index--;
    }

    System.out.println(result);
  }

}
