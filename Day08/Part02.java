import java.util.List;
import java.util.ArrayList;

public class Part02 {
    public static int Solve(List<String> input) {
        int sum = 0;
        
        for (String signal : input) {
            int index = signal.indexOf("|");
            String wires = signal.substring(0, index - 1);
            
            Pattern pattern = new Pattern();
            List<String> visited = new ArrayList<>();
            for (int i = 2; i <= 4; i++) {
                String[] wire = wires.split(" ");
                
                for (String w : wire) {
                    boolean check = false;
                    if (w.length() == i) {
                        check = true;
                        if (i == 2) {
                            visited.add(w.substring(0, 1));
                            visited.add(w.substring(1, 2));
                            pattern.SetOne(w.substring(0, 1), w.substring(1, 2));
                        } else if (i == 3) {
                            for (int j = 0; j < 3; j++) {
                                String letter = w.substring(j, j + 1);
                                if (!visited.contains(letter)) {
                                    visited.add(letter);
                                    pattern.SetSeven(letter);
                                    break;
                                }
                            }
                        } else {
                            int counter = 0;
                            String first = "";
                            String second = "";
                            for (int j = 0; j < 4; j++) {
                                String letter = w.substring(j, j + 1);
                                if (!visited.contains(letter)) {
                                    if (counter == 0) {
                                        first = letter;
                                        visited.add(letter);
                                        counter++;
                                    } else {
                                        second = letter;
                                        visited.add(letter);
                                        break;
                                    } 
                                } 
                            }
                            pattern.SetFour(first, second);
                        }
                    }
                    if (check)
                        break;
                }
            }
            
            int counter = 0;
            String first = "";
            String second = "";
            for (char c = 'a'; ; c++) {
                if (!visited.contains(Character.toString(c))) {
                    if (counter == 0) {
                        first = Character.toString(c);
                        counter++;
                    } else {
                        second = Character.toString(c);
                        break;
                    }
                }
            }
            pattern.SetOther(first, second);

            int number = 0;
            String[] output = signal.substring(index + 2).split(" ");
            ValidPattern valid = pattern.CreateValidPattern(wires.split(" "));
            
            for (String digit : output)
                number = number * 10 + valid.Value(digit);

            sum += number;
            
        }

        return sum;
    }
}