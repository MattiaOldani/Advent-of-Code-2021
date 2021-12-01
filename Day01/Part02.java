import java.util.List;

public class Part02 {
    public static int Solve(List<Integer> input) {
        int counter = 0;
        
        for (int i = 1; i < input.size() - 2; i++) {
            int sum1, sum2;
            sum1 = input.get(i - 1) + input.get(i) + input.get(i + 1);
            sum2 = input.get(i) + input.get(i + 1) + input.get(i + 2);
            if (sum1 < sum2)
                counter++;
        }

        return counter;
    }
}