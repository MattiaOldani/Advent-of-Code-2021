import java.util.List;

public class Part01 {
    public static int Solve(List<String> input) {
        Path p = new Path(input);
        p.FindPath(1);

        return p.Valid();
    }
}