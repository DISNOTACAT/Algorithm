import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nums = br.readLine().split(" ");
    int pricePerOne = Integer.parseInt(nums[0]);
    int pricePerTwo = Integer.parseInt(nums[1]) * 2;
    int pricePerThree = Integer.parseInt(nums[2]) * 3;

    int[] times = new int[100];

    for(int i = 0; i < 3; i++) {
      String[] str = br.readLine().split(" ");
      int inTime = Integer.parseInt(str[0]);
      int outTime = Integer.parseInt(str[1]);

      for(int j = inTime; j < outTime; j++) {
        times[j-1]++;
      }
    }

    int totalPrice = 0;
    for(int truck : times) {
      if(truck == 3) {
        totalPrice += pricePerThree;
      }
      if(truck == 2) {
        totalPrice += pricePerTwo;
      }
      if(truck == 1) {
        totalPrice += pricePerOne;
      }
    }

    System.out.println(totalPrice);
  }

}
