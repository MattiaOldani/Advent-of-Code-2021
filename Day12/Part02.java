import java.util.List;

public class Part02 {
    public static int Solve(List<String> input) {
        Path p = new Path(input);
        p.FindPath(2);

        return p.Valid();
    }
}