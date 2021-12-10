public class Parenthesis {
    private String p;
    private static String[] valid = {"()", "[]", "{}", "<>"};
    private static String[] open = {"(", "[", "{", "<"};

    public Parenthesis(String open, String close) {
        p = new String(open + close);
    }

    public Parenthesis(String s) {
        p = new String(s);
    }

    public String Value() {
        return p;
    }

    public boolean IsOpen() {
        for (String v : open)
            if (p.equals(v))
                return true;

        return false;
    }

    public boolean IsValid() {
        for (String v : valid)
            if (p.equals(v))
                return true;

        return false;
    }

    public int Score1() {
        switch (p.substring(1, 2)) {
            case ")":
                return 3;
            case "]":
                return 57;
            case "}":
                return 1197;
            default:
                return 25137;
        }
    }

    public int Score2() {
        switch (p) {
            case "(":
                return 1;
            case "[":
                return 2;
            case "{":
                return 3;
            default:
                return 4;
        }
    }
}