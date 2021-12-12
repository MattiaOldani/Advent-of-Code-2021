import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path {
    private int[][] matrix;
    private List<String> vertex;
    private List<List<String>> path;
    private List<String> lower;

    public Path(List<String> input) {
        vertex = new ArrayList<>();
        for (String edge : input) {
            String[] v = edge.split("-");
            if (!vertex.contains(v[0]))
                vertex.add(v[0]);
            if (!vertex.contains(v[1]))
                vertex.add(v[1]);
        }
        Collections.sort(vertex);

        matrix = new int[vertex.size()][vertex.size()];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                matrix[i][j] = 0;

        lower = new ArrayList<>();
        for (String edge : input) {
            String[] se = edge.split("-");
            if (se[0].toLowerCase().equals(se[0]) && !lower.contains(se[0]))
                lower.add(se[0]);
            if (se[1].toLowerCase().equals(se[1]) && !lower.contains(se[1]))
                lower.add(se[1]);
            int start = vertex.indexOf(se[0]);
            int end = vertex.indexOf(se[1]);
            matrix[start][end] = 1;
            matrix[end][start] = 1;
        }

        path = new ArrayList<>();
    }

    public void FindPath(int mode) {
        int index = vertex.indexOf("start");
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[index][i] == 1) {
                path.add(new ArrayList<>());
                path.get(path.size() - 1).add("start");
                path.get(path.size() - 1).add(vertex.get(i));
                if (mode == 1)
                    RecursivePath1(i, path.size() - 1);
                else
                    RecursivePath2(i, path.size() - 1);
            }
        }
    }

    private void RecursivePath1(int start, int pathIndex) {
        if (vertex.get(start).equals("end"))
            return;

        for (int i = 0; i < matrix.length; i++) {
            List<String> current = path.get(pathIndex);
            if (matrix[start][i] == 1) {
                String end = vertex.get(i);
                boolean flag = false;
                for (int j = 0; j < current.size(); j++) {
                    flag = flag || end.toLowerCase().equals(current.get(j));
                }
                if (!flag) {
                    path.add(new ArrayList<>(current));
                    path.get(path.size() - 1).add(vertex.get(i));
                    RecursivePath1(i, path.size() - 1);
                }
            }
        }
    }

    private void RecursivePath2(int start, int pathIndex) {
        if (vertex.get(start).equals("end"))
            return;

        for (int i = 0; i < matrix.length; i++) {
            List<String> current = path.get(pathIndex);
            if (matrix[start][i] == 1) {
                String end = vertex.get(i);
                boolean flag = true;
                if (end.toLowerCase().equals(end)) {
                    int total = 0;
                    for (String lw : lower) {
                        int counter = 0;
                        
                        for (String c : current)
                            if (lw.equals(c))
                                counter++;
                        
                        if (counter == 2)
                            total++;
                    }
                    
                    int occurrency = 0;
                    for (String c : current)
                        if (end.equals(c))
                            occurrency++;

                    if (occurrency > 0 && (end.equals("start") || end.equals("end") || total > 0))
                        flag = false;
                }
                if (flag) {
                    path.add(new ArrayList<>(current));
                    path.get(path.size() - 1).add(vertex.get(i));
                    RecursivePath2(i, path.size() - 1);
                }
            }
        }
    }

    public int Valid() {
        List<List<String>> sium = new ArrayList<>();
        int counter = 0;
        for (List<String> p : path)
            if (p.get(p.size() - 1).equals("end")) {
                sium.add(p);
                counter++;
            }
        
        return counter;
    }
}
