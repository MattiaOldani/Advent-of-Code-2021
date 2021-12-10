import java.util.ArrayList;
import java.util.List;

public class Part01 {
    public static int Solve(List<String> input) {
        int total = 0;

        for (String expression : input) {
            List<Parenthesis> parenthesis = new ArrayList<>();
            for (int i = 0; i < expression.length(); i++) {
                Parenthesis p = new Parenthesis(expression.substring(i, i + 1));
                if (p.IsOpen())
                    parenthesis.add(p);
                else {
                    Parenthesis open = parenthesis.get(parenthesis.size() - 1);
                    Parenthesis complete = new Parenthesis(open.Value(), p.Value());
                    if (!complete.IsValid()) {
                        total += complete.Score1();
                        break;
                    }
                    parenthesis.remove(parenthesis.size() - 1);
                }
            }
        }

        return total;
    }
}