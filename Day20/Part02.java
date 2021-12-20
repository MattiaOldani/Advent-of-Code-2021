import java.util.List;

public class Part02 {
    public static int Solve(List<String> input, String algo) {
        String[][] grid = new String[input.size() + 2][input.size() + 2];
        for (int i  = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[i].length - 1)
                    grid[i][j] = ".";
                else
                    grid[i][j] = input.get(i - 1).substring(j - 1, j);
            }
        }

        for (int t = 0; t < 50; t++) {
            String[][] new_grid = new String[grid.length + 2][grid[0].length + 2];
            for (int i = 0; i < new_grid.length; i++)
                for (int j = 0; j < new_grid[i].length; j++)
                    if (i == 0 || i == new_grid.length - 1 || j == 0 || j == new_grid[i].length - 1)
                        new_grid[i][j] = (t % 2 == 0 ? "#" : ".");

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    StringBuilder sb = new StringBuilder();
                    if (i == 0)
                        sb.append(t % 2 == 0 ? "000" : "111");
                    else {
                        if (j == 0)
                            sb.append(t % 2 == 0 ? "0" : "1");
                        else
                            sb.append(grid[i - 1][j - 1].equals("#") ? "1" : "0");
                        sb.append(grid[i - 1][j].equals("#") ? "1" : "0");
                        if (j == grid[i].length - 1)
                            sb.append(t % 2 == 0 ? "0" : "1");
                        else
                            sb.append(grid[i - 1][j + 1].equals("#") ? "1" : "0");
                    }

                    if (j == 0)
                        sb.append(t % 2 == 0 ? "0" : "1");
                    else
                        sb.append(grid[i][j - 1].equals("#") ? "1" : "0");
                    sb.append(grid[i][j].equals("#") ? "1" : "0");
                    if (j == grid[i].length - 1)
                        sb.append(t % 2 == 0 ? "0" : "1");
                    else
                        sb.append(grid[i][j + 1].equals("#") ? "1" : "0");

                    if (i == grid.length - 1)
                        sb.append(t % 2 == 0 ? "000" : "111");
                    else {
                        if (j == 0)
                            sb.append(t % 2 == 0 ? "0" : "1");
                        else
                            sb.append(grid[i + 1][j - 1].equals("#") ? "1" : "0");
                        sb.append(grid[i + 1][j].equals("#") ? "1" : "0");
                        if (j == grid[i].length - 1)
                            sb.append(t % 2 == 0 ? "0" : "1");
                        else
                            sb.append(grid[i + 1][j + 1].equals("#") ? "1" : "0");
                    }

                    int index = Integer.parseInt(sb.toString(), 2);
                    new_grid[i + 1][j + 1] = algo.substring(index, index + 1);
                }
            }

            grid = new String[new_grid.length][new_grid[0].length];
            for (int i = 0; i < grid.length; i++)
                for (int j = 0; j < grid[i].length; j++)
                    grid[i][j] = new_grid[i][j];
        }

        int total = 0;
        for (String[] row : grid)
            for (String cell : row)
                if (cell.equals("#"))
                    total++;

        return total;
    }
}