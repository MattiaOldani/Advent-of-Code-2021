import java.util.Scanner;

public class Day17 {
    public static void main(String[] args) {
        String input = new String();
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        }
        scanner.close();

        System.out.println("Part-01: " + Part01.Solve(input));
        System.out.println("Part-02: " + Part02.Solve(input));
    }
}