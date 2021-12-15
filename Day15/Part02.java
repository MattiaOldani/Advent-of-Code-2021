import java.util.List;

public class Part02 {
    public static int Solve(List<String> input) {
        Graph g = new Graph(input, 2);
        return g.Dijkstra();
    }
}