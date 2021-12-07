import java.util.Scanner;

public class Day07 {
    public static void main(String[] args) {
        String input = "";
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            input = scanner.nextLine();
        }
        scanner.close();

        System.out.println("Part-01: " + Part01.Solve(input));
        System.out.println("Part-02: " + Part02.Solve(input));
    }
}