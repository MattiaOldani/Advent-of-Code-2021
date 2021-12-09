import java.util.List;

public class Part01 {
    public static int Solve(List<String> input) {
        int[][] grid = new int[input.size()][];
        
        for (int i = 0; i < input.size(); i++) {
            String row = input.get(i);
            grid[i] = new int[row.length()];
            for (int j = 0; j < row.length(); j++) {
                grid[i][j] = Integer.parseInt(row.substring(j, j + 1));
            }
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                boolean flag = true;
                if (i != 0)
                    flag = flag && (grid[i][j] < grid[i -1][j]);
                if (i != grid.length - 1)
                    flag = flag && (grid[i][j] < grid[i + 1][j]);
                if (j != 0)
                    flag = flag && (grid[i][j] < grid[i][j - 1]);
                if (j != grid[i].length - 1)
                    flag = flag && (grid[i][j] < grid[i][j + 1]);
                if (flag)
                    sum = sum + grid[i][j] + 1;
            }
        }

        return sum;
    }
}