import java.util.List;

public class Part02 {
    public static int Solve(List<String> input) {
        int[][] grid = new int[10][10];

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                grid[i][j] = Integer.parseInt(input.get(i).substring(j, j + 1));

        int step = 0;
        while (true) {
            boolean[][] flashed = new boolean[10][10];
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 10; j++)
                    flashed[i][j] = false;
            
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 10; j++)
                    grid[i][j]++;
            
            step++;
            boolean sium = true;
            while (sium) {
                sium = false;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (grid[i][j] > 9 && !flashed[i][j]) {
                            sium = true;
                            flashed[i][j] = true;
                            if (i != 0) {
                                grid[i - 1][j]++;
                                if (j != 0)
                                    grid[i - 1][j - 1]++;
                                if (j != 9)
                                    grid[i - 1][j + 1]++;
                            }
                            if (i != 9) {
                                grid[i + 1][j]++;
                                if (j !=  0)
                                    grid[i + 1][j - 1]++;
                                if (j != 9)
                                    grid[i + 1][j + 1]++;
                            }
                            if (j != 0)
                                grid[i][j - 1]++;
                            if (j != 9)
                                grid[i][j + 1]++;
                        }
                    }
                }
            }
            
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 10; j++)
                    if (grid[i][j] > 9)
                        grid[i][j] = 0;

            boolean all = true;
            for (int i = 0; i < 10 && all; i++)
                for (int j = 0; j < 10 && all; j++)
                    all = all && flashed[i][j];
            
            if (all)
                break;
        }

        return step;
    }
}