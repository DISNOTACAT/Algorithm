import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    List<StringComparator> list = new ArrayList<>();
    for(int i = 0; i < N; i++){
      list.add(new StringComparator(br.readLine()));
    }

    list.sort(Comparator.comparing(StringComparator::getLength)
        .thenComparing(StringComparator::getSum)
        .thenComparing(StringComparator::getStr));

    for(int i = 0; i < N; i++){
      System.out.println(list.get(i).getStr());
    }
  }




  private static class StringComparator {

    String str;
    int length;
    int sum;

    public StringComparator(String str) {
      this.str = str;
      this.length = str.length();
      this.sum = getSum(str);
    }

    public String getStr() {
      return str;
    }

    public int getSum() {
      return sum;
    }

    public int getLength() {
      return length;
    }

    private static int getSum(String s) {

        int sum = 0;

        for(int i = 0; i < s.length(); i++){
          if(s.charAt(i) > '0' && s.charAt(i) <= '9'){
            sum += s.charAt(i) - '0';
          }
        }
        return sum;
      }
    }

}
