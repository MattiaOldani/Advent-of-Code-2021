import java.util.List;

public class Part02 {
    public static void Solve(List<String> input, List<String> moves) {
        int max_x, max_y;
        String[] first = input.get(0).split(",");
        max_x = Integer.parseInt(first[0]);
        max_y = Integer.parseInt(first[1]);

        for (int i = 1; i < input.size(); i++) {
            String[] line = input.get(i).split(",");
            int x = Integer.parseInt(line[0]);
            if (x > max_x)
                max_x = x;
            int y = Integer.parseInt(line[1]);
            if (y > max_y)
                max_y = y;
        }
        max_x++;
        max_y++;

        int[][] grid = new int[max_y][max_x];
        for (int i = 0; i < max_y; i++)
            for (int j = 0; j < max_x; j++)
                grid[i][j] = 0;
        
        for (String point : input) {
            String[] p = point.split(",");
            int x = Integer.parseInt(p[0]);
            int y = Integer.parseInt(p[1]);
            grid[y][x] = 1;
        }

        for (String move : moves) {
            String[] m = move.split("=");
            String position = m[0].substring(m[0].length() - 1, m[0].length());
            int line = Integer.parseInt(m[1]);
            if (position.equals("y")) {
                int[][] new_grid = new int[line][max_x];
                for (int t = line - 1, k = line + 1; t >= 0 && k < max_y; t--, k++) {
                    for (int j = 0; j < max_x; j++) {
                        new_grid[t][j] = grid[t][j] + grid[k][j];
                        if (new_grid[t][j] == 2)
                            new_grid[t][j] = 1;
                    }
                }
                grid = new int[line][max_x];
                for (int i = 0; i < line; i++)
                    for (int j = 0; j < max_x; j++)
                        grid[i][j] = new_grid[i][j];
                max_y = line;
            } else {
                int[][] new_grid = new int[max_y][line];
                for (int t = line - 1, k = line + 1; t >= 0 && k < max_x; t--, k++) {
                    for (int i = 0; i < max_y; i++) {
                        new_grid[i][t] = grid[i][t] + grid[i][k];
                        if (new_grid[i][t] == 2)
                            new_grid[i][t] = 1;
                    }
                }
                grid = new int[max_y][line];
                for (int i = 0; i < max_y; i++)
                    for (int j = 0; j < line; j++)
                        grid[i][j] = new_grid[i][j];
                max_x = line;
            }
        }
        
        for (int i = 0; i < max_y; i++) {
            for (int j = 0; j < max_x; j++)
                System.out.printf("%c", grid[i][j] == 1 ? '#' : '.');
            System.out.println();
        }
    }
}