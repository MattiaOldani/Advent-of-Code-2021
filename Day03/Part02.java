import java.util.ArrayList;
import java.util.List;

public class Part02 {
    public static int Solve(List<String> input) {
        List<String> backup = new ArrayList<>(input);
        return Parser(input, 1) * Parser(backup, -1);
    }

    private static int Parser(List<String> input, int modality) {
        int index = 0;

        while (input.size() > 1) {
            int counterOne = 0, counterZero = 0;

            for (String bit : input) {
                if (bit.toCharArray()[index] == '1')
                    counterOne++;
                else
                    counterZero++;
            }

            char max = (counterOne >= counterZero) ?
                        ((modality == 1) ? '1' : '0') :
                        ((modality == 1) ? '0' : '1');

            for (int i = 0; i < input.size(); i++)
                if (input.get(i).toCharArray()[index] != max)
                    input.remove(input.get(i--));

            index++;
        }
        
        return Integer.parseInt(input.get(0), 2);
    }
}