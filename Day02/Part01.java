import java.util.List;

public class Part01 {
    public static int Solve(List<String> input) {
        int depth = 0, forward = 0;

        for (String x : input) {
            String[] cmd = x.split(" ");
            if (cmd[0].equals("forward"))
                forward += Integer.parseInt(cmd[1]);
            else if (cmd[0].equals("down"))
                depth += Integer.parseInt(cmd[1]);
            else
                depth -= Integer.parseInt(cmd[1]);
        }

        return depth * forward;
    }
}