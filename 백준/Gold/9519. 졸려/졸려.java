import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        String word = br.readLine();

        List<String> states = new ArrayList<>();
        states.add(word);

        while (true) {
            word = transform(word);
            if (states.contains(word)) {
                break;
            }
            states.add(word);
        }

        int cycleLength = states.size();
        int finalIndex = X % cycleLength;

        System.out.println(states.get(finalIndex));
    }

    private static String transform(String s) {
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                front.append(s.charAt(i));
            } else {
                back.insert(0, s.charAt(i));
            }
        }
        
        return front.toString() + back.toString();
    }
}
