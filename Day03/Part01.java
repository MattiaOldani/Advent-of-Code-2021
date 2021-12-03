import java.util.List;
import java.util.ArrayList;

public class Part01 {
    public static int Solve(List<String> input) {
        List<Integer> one = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();

        for (int i = 0; i < input.get(0).length(); i++) {
            one.add(0);
            zero.add(0);
        }
        
        for (String bit : input) {
            int index = 0;
            for (char ch : bit.toCharArray()) {
                if (ch == '1')
                    one.set(index, one.get(index) + 1);
                else
                    zero.set(index, zero.get(index) + 1);
                index++;
            }
        }
        
        StringBuilder gameRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();
        for (int i = 0; i < one.size(); i++) {
            gameRate.append(one.get(i) > zero.get(i) ? 1 : 0);
            epsilonRate.append(one.get(i) > zero.get(i) ? 0 : 1);
        }

        return Integer.parseInt(gameRate.toString(), 2) * Integer.parseInt(epsilonRate.toString(), 2);
    }
}