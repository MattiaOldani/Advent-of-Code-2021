import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Day13 {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        List<String> moves = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals(""))
                break;
            input.add(line);
        }

        while (scanner.hasNextLine()) {
            moves.add(scanner.nextLine());
        }
        scanner.close();

        System.out.println("Part-01: " + Part01.Solve(input, moves.get(0)));
        System.out.println("Part-02:");
        Part02.Solve(input, moves);
    }
}