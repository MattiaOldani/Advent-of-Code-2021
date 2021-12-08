import java.util.List;
import java.util.ArrayList;

public class Pattern {
    private String top;
    private List<String> middle;
    private List<String> topRight;
    private List<String> down;

    public Pattern() {
        top = "";
        middle = new ArrayList<>();
        topRight = new ArrayList<>();
        down = new ArrayList<>();
    }

    public void SetOne(String first, String second) {
        topRight.add(first);
        topRight.add(second);
    }

    public void SetSeven(String first) {
        top = first;
    }

    public void SetFour(String first, String second) {
        middle.add(first);
        middle.add(second);
    }

    public void SetOther(String first, String second) {
        down.add(first);
        down.add(second);
    }

    public ValidPattern CreateValidPattern(String[] wires) {
        for (int i = 0; i < 2; i++) {
            String tr = topRight.get(i);
            String dr = topRight.get((i + 1) % 2);
            for (int j = 0; j < 2; j++) {
                String tl = middle.get(j);
                String m = middle.get((j + 1) % 2);
                for (int t = 0; t < 2; t++) {
                    String dl = down.get(t);
                    String d = down.get((t + 1) % 2);
                    
                    ValidPattern vp = new ValidPattern(top, m, d, tr, dr, tl, dl, wires);
                    if (vp.IsValid())
                        return vp;
                }
            }
        }
        
        return null;
    }
}
