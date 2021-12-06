import java.util.List;
import java.util.ArrayList;

public class Part02 {
    public static long Solve(String input) {
        List<Long> fish = new ArrayList<>();

        for (int i = 0; i < 9; i++)
            fish.add(0l);

        String[] start = input.split(",");
        for (int i = 0; i < start.length; i++) {
            int n = Integer.parseInt(start[i], 10);
            fish.set(n, fish.get(n) + 1);
        }

        for (int i = 0; i <= 256; i++) {
            long tmp = fish.get(8);
            for (int t = 7; t >= 0; t--) {
                long current = fish.get(t);
                fish.set(t, tmp);
                tmp = current;
            }
            fish.set(8, tmp);
            fish.set(6, fish.get(6) + tmp);
        }

        long total = 0;
        for (int i = 0; i < 8; i++)
            total += fish.get(i);
        
        return total;
    }
}