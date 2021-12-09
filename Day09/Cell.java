public class Cell {
    private int i;
    private int j;
    
    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int BasinValue(int[][] grid, boolean[][] visited) {
        int sum = 1;
        
        if (i != 0 && grid[i - 1][j] > grid[i][j] && !visited[i - 1][j]) {
            Cell c = new Cell(i - 1, j);
            visited[i - 1][j] = true;
            sum += c.BasinValue(grid, visited);
        }
        if (i != grid.length - 1 && grid[i + 1][j] > grid[i][j] && !visited[i + 1][j]) {
            Cell c = new Cell(i + 1, j);
            visited[i + 1][j] = true;
            sum += c.BasinValue(grid, visited);
        }
        if (j != 0 && grid[i][j - 1] > grid[i][j] && !visited[i][j - 1]) {
            Cell c = new Cell(i, j - 1);
            visited[i][j - 1] = true;
            sum += c.BasinValue(grid, visited);
        }
        if (j != grid[i].length - 1 && grid[i][j + 1] > grid[i][j] && !visited[i][j + 1]) {
            Cell c = new Cell(i, j + 1);
            visited[i][j + 1] = true;
            sum += c.BasinValue(grid, visited);
        }

        return sum;
    }
}
