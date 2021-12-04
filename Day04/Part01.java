import java.util.List;
import java.util.ArrayList;

public class Part01 {
    public static int Solve(List<String> input, String numbers) {
        List<Board> boards = new ArrayList<>();
        List<String> rows = new ArrayList<>();

        int counter = 0;
        for (int i = 0; i < input.size(); i++) {
            if (counter == 5) {
                boards.add(new Board(rows));
                rows.clear();
                counter = 0;
            } else {
                rows.add(input.get(i).trim().replaceAll("  ", " "));
                counter++;
            }
        }
        boards.add(new Board(rows));

        List<Integer> extract = new ArrayList<>();
        String[] n = numbers.split(",");
        for (int i = 0; i < n.length; i++) {
            extract.add(Integer.parseInt(n[i], 10));
        }

        int res = 0;
        for (int number : extract) {
            for (Board board : boards) {
                board.Mark(number);
                if (board.Check()) {
                    res = board.Score(number);
                    break;
                }
            }
            if (res > 0)
                break;
        }

        return res;
    }
}