import java.util.List;

public class Part01 {
    public static int Solve(List<String> input) {
        Graph g = new Graph(input, 1);
        return g.Dijkstra();
    }
}