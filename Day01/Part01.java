import java.util.List;

public class Part01 {
    public static int Solve(List<Integer> input) {
        int counter = 0;
        
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i - 1) < input.get(i))
                counter++;
        }
        
        return counter;
    }
}