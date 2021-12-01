import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            input.add(scanner.nextInt());
        }
        scanner.close();

        System.out.println("Part-01: " + Part01.Solve(input));
        System.out.println("Part-02: " + Part02.Solve(input));
    }
}