import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Day14 {
    public static void main(String[] args) {
        String input = new String();
        List<String> rules = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            rules.add(scanner.nextLine());
        }
        scanner.close();

        System.out.println("Part-01: " + Part01.Solve(input, rules));
        System.out.println("Part-02: " + Part02.Solve(input, rules));
    }
}