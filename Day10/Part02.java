import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Part02 {
    public static long Solve(List<String> input) {
        List<Long> scores = new ArrayList<>();

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
                        parenthesis.clear();;
                        break;
                    }
                    parenthesis.remove(parenthesis.size() - 1);
                }
            }
            
            if (parenthesis.size() == 0)
                continue;
            
            long score = 0;
            for (int i = parenthesis.size() - 1; i >= 0; i--) {
                Parenthesis p = parenthesis.get(i);
                score = (score * 5) + p.Score2();
            }
            scores.add(score);
        }

        Collections.sort(scores);

        return scores.get(scores.size() / 2);
    }
}