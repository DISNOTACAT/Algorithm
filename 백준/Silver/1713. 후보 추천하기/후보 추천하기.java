import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {

  public static class Candidate implements Comparable<Candidate> {
    int number;
    int time;
    int count;

    @Override
    public int compareTo(Candidate o) {
      if (this.count != o.count) {
        return this.count - o.count; // 추천 수 적은 게 먼저
      }
      return this.time - o.time; // 오래된 게 먼저
    }

    public Candidate(int number, int time) {
      this.number = number;
      this.time = time;
      this.count = 1;
    }

    public void updateCount() {
      this.count++;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[] input = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

    Map<Integer, Candidate> map = new TreeMap<>();
    PriorityQueue<Candidate> frame = new PriorityQueue();
    for(int i = 0; i < M; i++){

      int num = input[i];

      if(map.containsKey(num)){
        Candidate oldCandidate = map.get(num);
        oldCandidate.updateCount();

        // remove 후 다시 offer 해야 재정렬
        frame.remove(oldCandidate);
        frame.offer(oldCandidate);
      } else {
        if(frame.size() == N) {
          Candidate removeCandidate = frame.poll();
          map.remove(removeCandidate.number);
        }

        Candidate newCandidate = new Candidate(num, i);
        frame.offer(newCandidate);
        map.put(num, newCandidate);
      }
    }

    for (int num : map.keySet()) {
      System.out.print(num + " ");
    }
  }

}
