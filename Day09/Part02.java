import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Part02 {
    public static int Solve(List<String> input) {
        int[][] grid = new int[input.size()][];
        
        for (int i = 0; i < input.size(); i++) {
            String row = input.get(i);
            grid[i] = new int[row.length()];
            for (int j = 0; j < row.length(); j++) {
                grid[i][j] = Integer.parseInt(row.substring(j, j + 1));
            }
        }

        List<Integer> basins = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Cell cell = new Cell(i, j);
                boolean[][] visited = new boolean[grid.length][];
                for (int t = 0; t < visited.length; t++) {
                    visited[t] = new boolean[grid[t].length];
                    for (int k = 0; k < visited[t].length; k++)
                        if (grid[t][k] == 9)
                            visited[t][k] = true;
                        else
                            visited[t][k] = false;
                }
                basins.add(cell.BasinValue(grid, visited));
            }
        }

        Collections.sort(basins);
        int size = basins.size() - 1;

        return basins.get(size) * basins.get(size - 1) * basins.get(size - 2);
    }
}