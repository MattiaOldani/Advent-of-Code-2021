import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Part02 {
    public static long Solve(String input, List<String> rules) {
        List<String> polymer = new ArrayList<>();
        List<Long> occurrency = new ArrayList<>();
        
        List<String> couples = new ArrayList<>();
        List<Long> count = new ArrayList<>();
        
        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();

        for (String rule : rules) {
            String[] p = rule.split(" -> ");
            left.add(p[0]);
            right.add(p[1]);
            if (!polymer.contains(p[0].substring(0, 1)))
                polymer.add(p[0].substring(0, 1));
            if (!polymer.contains(p[0].substring(1, 2)))
                polymer.add(p[0].substring(1, 2));
        }

        for (int i = 0; i < polymer.size(); i++) {
            String p = polymer.get(i);
            occurrency.add(0l);
            for (int j = 0; j < input.length(); j++)
                if (p.equals(input.substring(j, j + 1)))
                    occurrency.set(i, occurrency.get(i) + 1);
        }

        for (int i = 0; i < input.length() - 1; i++) {
            if (!couples.contains(input.substring(i, i + 2))) {
                couples.add(input.substring(i, i + 2));
                count.add(1l);
            } else {
                int index = couples.indexOf(input.substring(i, i + 2));
                count.set(index, count.get(index) + 1);
            }
        }   

        for (int i = 0; i < 40; i++) {
            List<String> new_couples = new ArrayList<>();
            List<Long> new_count = new ArrayList<>();
            for (int t = 0; t < couples.size(); t++) {
                if (left.contains(couples.get(t))) {
                    String res = right.get(left.indexOf(couples.get(t)));
                    int index = polymer.indexOf(res);
                    occurrency.set(index, occurrency.get(index) + count.get(t));
                    String first = couples.get(t).substring(0, 1) + res;
                    String second = res + couples.get(t).substring(1, 2);
                    if (!new_couples.contains(first)) {
                        new_couples.add(first);
                        new_count.add(count.get(t));
                    } else {
                        int k = new_couples.indexOf(first);
                        new_count.set(k, new_count.get(k) + count.get(t));
                    }
                    if (!new_couples.contains(second)) {
                        new_couples.add(second);
                        new_count.add(count.get(t));
                    } else {
                        int k = new_couples.indexOf(second);
                        new_count.set(k, new_count.get(k) + count.get(t));
                    }
                }
            }
            couples = new ArrayList<>(new_couples);
            count = new ArrayList<>(new_count);
        }
        Collections.sort(occurrency);

        return occurrency.get(occurrency.size() - 1) - occurrency.get(0);
    }
}