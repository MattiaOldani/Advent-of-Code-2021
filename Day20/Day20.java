import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day20 {
    public static void main(String[] args) {
        String algo = new String();
        List<String> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            algo = scanner.nextLine();
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine());
        }
        scanner.close();

        System.out.println("Part-01: " + Part01.Solve(input, algo));
        System.out.println("Part-02: " + Part02.Solve(input, algo));
    }
}