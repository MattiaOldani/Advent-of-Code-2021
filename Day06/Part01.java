import java.util.List;
import java.util.ArrayList;

public class Part01 {
    public static int Solve(String input) {
        List<Integer> fish = new ArrayList<>();

        for (int i = 0; i < 9; i++)
            fish.add(0);

        String[] start = input.split(",");
        for (int i = 0; i < start.length; i++) {
            int n = Integer.parseInt(start[i], 10);
            fish.set(n, fish.get(n) + 1);
        }

        for (int i = 0; i <= 80; i++) {
            int tmp = fish.get(8);
            for (int t = 7; t >= 0; t--) {
                int current = fish.get(t);
                fish.set(t, tmp);
                tmp = current;
            }
            fish.set(8, tmp);
            fish.set(6, fish.get(6) + tmp);
        }

        int total = 0;
        for (int i = 0; i < 8; i++)
            total += fish.get(i);
        
        return total;
    }
}