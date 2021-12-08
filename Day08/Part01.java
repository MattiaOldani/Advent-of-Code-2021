import java.util.List;

public class Part01 {
    public static int Solve(List<String> input) {
        int valid = 0;
        
        for (String signal : input) {
            int index = signal.indexOf("|");
            String output = signal.substring(index + 2);
            
            for (String pattern : output.split(" ")) {
                int len = pattern.length();
                if (len <= 4 || len == 7)
                    valid++;
            }
        }

        return valid;
    }
}