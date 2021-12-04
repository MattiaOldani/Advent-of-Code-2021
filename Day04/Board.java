import java.util.List;
import java.util.ArrayList;

public class Board {
    private List<List<Integer>> board;
    private List<List<Boolean>> mark;

    public Board(List<String> rows) {
        board = new ArrayList<>();
        mark = new ArrayList<>();

        for (int i = 0; i < rows.size(); i++) {
            String[] numbers = rows.get(i).split(" ");
            List<Integer> row = new ArrayList<>();
            List<Boolean> mk = new ArrayList<>();
            for (int j = 0; j < numbers.length; j++) {
                row.add(Integer.parseInt(numbers[j], 10));
                mk.add(false);
            }
            board.add(row);
            mark.add(mk);
        }
    }

    public void Mark(int n) {
        for (int i = 0; i < board.size(); i++) {
            List<Integer> current = board.get(i);
            if (current.contains(n)) {
                int index = current.indexOf(n);
                List<Boolean> new_row = mark.get(i);
                new_row.set(index, true);
                mark.set(i, new_row);
                break;
            }
        }
    }

    public boolean Check() {
        for (int i = 0; i < mark.size(); i++)
            if (!mark.get(i).contains(false))
                return true;

        for (int i = 0; i < mark.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < mark.size(); j++) {
                flag = flag && mark.get(j).get(i);
            }
            if (flag)
                return true;
        }
        
        return false;
    }

    public int Score(int n) {
        int score = 0;
        for (int i = 0; i < board.size(); i++) {
            if (!mark.get(i).contains(false))
                continue;
            
            for (int j = 0; j < board.size(); j++) {
                if (!mark.get(i).get(j))
                    score += board.get(i).get(j);
            }
        }

        return score * n;
    }
}
