import java.util.List;
import java.util.ArrayList;

public class Graph {
    private int[][] matrix;
    private Cell[][] d;
    private List<Cell> toVisit;

    public Graph(List<String> input, int mode) {
        if (mode == 1) {
            matrix = new int[input.size()][];
            for (int i = 0; i < input.size(); i++) {
                String line = input.get(i);
                matrix[i] = new int[line.length()];
                for (int j = 0; j < line.length(); j++) {
                    matrix[i][j] = Integer.parseInt(line.substring(j, j + 1));
                }
            }
        } else {
            matrix = new int[input.size() * 5][input.size() * 5];
            for (int i = 0; i < input.size(); i++) {
                String line = input.get(i);
                for (int j = 0; j < line.length(); j++) {
                    matrix[i][j] = Integer.parseInt(line.substring(j, j + 1));
                }
            }
            for (int i = input.size(); i < matrix.length; i++) {
                for (int j = 0; j < input.size(); j++) {
                    matrix[i][j] = matrix[i - input.size()][j] + 1;
                    if (matrix[i][j] > 9)
                        matrix[i][j] = 1;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = input.size(); j < matrix[i].length; j++) {
                    matrix[i][j] = matrix[i][j - input.size()] + 1;
                    if (matrix[i][j] > 9)
                        matrix[i][j] = 1;
                }
            }
        }
        
        d = new Cell[matrix.length][matrix[0].length];
        for (int i = 0; i < d.length; i++)
            for (int j = 0; j < d[i].length; j++) {
                if (i == 0 && j == 0)
                    d[i][j] = new Cell(i, j, 0);
                else
                    d[i][j] = new Cell(i, j, Integer.MAX_VALUE);
            }
        
        toVisit = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
            if (i == 0 && j == 0)
                toVisit.add(new Cell(i, j, 0));
            else
                toVisit.add(new Cell(i, j, Integer.MAX_VALUE));
    }

    public int Dijkstra() {
        while (toVisit.size() > 0) {
            int index = 0;
            int min = toVisit.get(0).getValue();
            for (int i = 1; i < toVisit.size(); i++)
                if (toVisit.get(i).getValue() < min) {
                    index = i;
                    min = toVisit.get(i).getValue();
                }
            
            Cell u = toVisit.get(index);
            toVisit.remove(index);
            int i = u.getRow();
            int j = u.getColumn();
            int value = u.getValue();
            
            if (i != 0 && value + matrix[i - 1][j] < d[i - 1][j].getValue()) {
                d[i - 1][j].setValue(value + matrix[i - 1][j]);
                index = FindIndex(i - 1, j);
                toVisit.set(index, new Cell(i - 1, j, d[i - 1][j].getValue()));
            }
            
            if (i != matrix.length - 1 && value + matrix[i + 1][j] < d[i + 1][j].getValue()) {
                d[i + 1][j].setValue(value + matrix[i + 1][j]);
                index = FindIndex(i + 1, j);
                toVisit.set(index, new Cell(i + 1, j, d[i + 1][j].getValue()));
            }

            if (j != 0 && value + matrix[i][j - 1] < d[i][j - 1].getValue()) {
                d[i][j - 1].setValue(value + matrix[i][j - 1]);
                index = FindIndex(i, j - 1);
                toVisit.set(index, new Cell(i, j - 1, d[i][j - 1].getValue()));
            }

            if (j != matrix[i].length - 1 && value + matrix[i][j + 1] < d[i][j + 1].getValue()) {
                d[i][j + 1].setValue(value + matrix[i][j + 1]);
                index = FindIndex(i, j + 1);
                toVisit.set(index, new Cell(i, j + 1, d[i][j + 1].getValue()));
            }
        }
        
        return d[d.length - 1][d.length - 1].getValue();
    }

    private int FindIndex(int i, int j) {
        for (int t = 0; t < toVisit.size(); t++) {
            Cell c = toVisit.get(t);
            if (c.getRow() == i && c.getColumn() == j)
                return t;
        }
        return 0;
    }
}
