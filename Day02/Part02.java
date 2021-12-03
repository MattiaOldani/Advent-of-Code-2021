import java.util.List;

public class Part02 {
    public static int Solve(List<String> input) {
        int depth = 0, forward = 0, aim = 0;

        for (String x : input) {
            String[] cmd = x.split(" ");
            if (cmd[0].equals("forward")) {
                forward += Integer.parseInt(cmd[1]);
                depth += (aim * Integer.parseInt(cmd[1]));
            }
            else if (cmd[0].equals("down"))
                aim += Integer.parseInt(cmd[1]);
            else
                aim -= Integer.parseInt(cmd[1]);
        }

        return depth * forward;
    }
}