import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04 {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String numbers = "";

        if (scanner.hasNext()) {
            numbers = scanner.nextLine();
            scanner.nextLine();
        }

        while (scanner.hasNext()) {
            input.add(scanner.nextLine());
        }
        scanner.close();

        System.out.println("Part-01: " + Part01.Solve(input, numbers));
        System.out.println("Part-02: " + Part02.Solve(input, numbers));
    }
}