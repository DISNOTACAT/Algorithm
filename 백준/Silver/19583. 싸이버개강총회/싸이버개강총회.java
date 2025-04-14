import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime startTime = LocalTime.parse(st.nextToken(), formatter);
    LocalTime endTime = LocalTime.parse(st.nextToken(), formatter);
    LocalTime streamTime = LocalTime.parse(st.nextToken(), formatter);

    Set<String> entered = new HashSet<>();

    int result = 0;
    String input = null;
    while((input = br.readLine()) != null)  {

      String[] str = input.split(" ");
      LocalTime time = LocalTime.parse(str[0], formatter);

      if(time.isBefore(startTime) || time.equals(startTime)) {
        entered.add(str[1]);
        continue;
      }

      if(time.isBefore(endTime) || time.isAfter(streamTime)) {
        continue;
      }
      
      if(entered.contains(str[1])) {
        result++;
        entered.remove(str[1]);
      }
    }

    System.out.println(result);
  }

}
