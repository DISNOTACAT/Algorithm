import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    int reverseNum = ~num + 1;
    int answerBit = num ^ reverseNum;
    System.out.println(Integer.bitCount(answerBit));

  }

}
