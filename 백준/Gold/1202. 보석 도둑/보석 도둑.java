import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*

4 4
1 100
2 200
13 300
10 500
10
10
10
14



가장 가벼운 가방 부터 담을 수 있는 가장 비싼 보석 찾기
10
10
10
14

가장 비싸고 가장 가벼운 순서로 보석 리스트
10 500
13 300
2 200
1 100


가장 비싼 보석부터 큐에 담기
(1번가방 = 10)
10 500 --> get

(2번가방 = 10)
13 300
2 200 --> get

(3번가방 = 10)
13 300
1 100 --> get

(4번가방 = 14)
13 300 --> get



4 4
10 500
13 300
10 200
4 100
4
5
10
14

(1번가방 = 4)
10 500
13 300
10 200
4 100 ---> get

(2번가방 = 5)
10 500
13 300
10 200
---> empty


 */
public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");
    int jewelCount = Integer.parseInt(str[0]);
    int bagCount = Integer.parseInt(str[1]);

    ArrayList<Jewel> jewelList = new ArrayList<>();

    for(int i = 0; i < jewelCount; i++) {
      String[] input = br.readLine().split(" ");
      int weight = Integer.parseInt(input[0]);
      int price = Integer.parseInt(input[1]);
      Jewel jewel = new Jewel(weight, price);
      jewelList.add(jewel);
    }

    jewelList.sort(Comparator
        .comparing(Jewel::getWeight)
        .thenComparing(Jewel::getPrice, Comparator.reverseOrder()));

    int[] bags = new int[bagCount];
    for(int i = 0; i < bagCount; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(bags);


    long totalPrice = 0;
    int jewelNumber = 0;

    // 작은 가방에서 부터 담을 수 있는 가장 비싼 가격의 보석
    PriorityQueue<Jewel> jewelQue = new PriorityQueue<>(Comparator.comparing(Jewel::getPrice, Comparator.reverseOrder()));

    for(int bagNumber = 0; bagNumber < bags.length; bagNumber++) {

      int bagWeight = bags[bagNumber];

      while(jewelNumber < jewelCount) {

        Jewel curJewel = jewelList.get(jewelNumber);

        if(bagWeight < curJewel.getWeight()){
          break;
        }

        jewelQue.add(curJewel);
        jewelNumber++;
      }

      if(jewelQue.isEmpty()) {
        continue;
      }

      totalPrice += jewelQue.poll().getPrice();
    }
    System.out.println(totalPrice);
  }


  private static class Jewel {
    private int weight;
    private int price;

    public Jewel(int weight, int price) {
      this.weight = weight;
      this.price = price;
    }

    public int getWeight() {
      return weight;
    }

    public int getPrice() {
      return price;
    }
  }

}
