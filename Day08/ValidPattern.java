import java.util.List;
import java.util.ArrayList;

public class ValidPattern {
    private List<String> pattern;
    private static Boolean[] zero = {true, false, true, true, true, true, true};
    private static Boolean[] one = {false, false, false, true, true, false, false};
    private static Boolean[] two = {true, true, true, true, false, false, true};
    private static Boolean[] three = {true, true, true, true, true, false, false};
    private static Boolean[] four = {false, true, false, true, true, true, false};
    private static Boolean[] five = {true, true, true, false, true, true, false};
    private static Boolean[] six = {true, true, true, false, true, true, true};
    private static Boolean[] seven = {true, false, false, true, true, false, false};
    private static Boolean[] eight = {true, true, true, true, true, true, true};
    private static Boolean[] nine = {true, true, true, true, true, true, false};
    private static Boolean[][] numbers = {
        zero, one, two, three, four, five, six, seven, eight, nine
    };
    private String[] wires;

    public ValidPattern(String t, String m, String d, String tr, String dr, String tl, String dl, String[] wires) {
        pattern = new ArrayList<>();
        pattern.add(t);
        pattern.add(m);
        pattern.add(d);
        pattern.add(tr);
        pattern.add(dr);
        pattern.add(tl);
        pattern.add(dl);
        this.wires = wires;
    }

    public boolean IsValid() {
        for (String wire : wires) {
            List<Boolean> check = new ArrayList<>();
            for (int i = 0; i < 7; i++)
                check.add(false);
            
            for (int i = 0; i < wire.length(); i++) {
                int index = pattern.indexOf(wire.substring(i, i + 1));
                check.set(index, true);
            }
            
            int total = 0;
            for (Boolean[] number : numbers) {
                int counter = 0;
                for (int i = 0; i < 7; i++) {
                    if (number[i] == check.get(i))
                        counter++;
                }
                if (counter == 7) {
                    total++;
                    break;
                }
            }
            if (total == 0)
                return false;
        }
        
        return true;
    }

    public int Value(String digit) {
        List<Boolean> number = new ArrayList<>();
        
        for (int i = 0; i < 7; i++)
            number.add(false);
        
        for (int i = 0; i < digit.length(); i++) {
            int index = pattern.indexOf(digit.substring(i, i + 1));
            number.set(index, true);
        }
        
        for (int i = 0; i < 10; i++) {
            int counter = 0;
            for (int j = 0; j < 7; j++) {
                if (numbers[i][j] == number.get(j))
                    counter++;    
            }
            if (counter == 7)
                return i;
        }

        return 0;
    }
}
