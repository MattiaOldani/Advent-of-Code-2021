public class Part02 {
    public static int Solve(String input) {
        String[] splitted = input.split(",");
        Integer[] positions = new Integer[splitted.length];
        int max = Integer.parseInt(splitted[0]);
        int min = Integer.parseInt(splitted[0]);

        positions[0] = Integer.parseInt(splitted[0]);
        for (int i = 1; i < splitted.length; i++) {
            int current = Integer.parseInt(splitted[i]);
            positions[i] = current;
            if (current > max)
                max = current;
            if (current < min)
                min = current;
        }

        int res = 0;
        int start = 0;
        for (int i = min; i <= max; i++) {
            int sum = 0;

            for (Integer n : positions)
                sum += Math.abs(n - i) * (Math.abs(n - i) + 1) / 2;
            
            if (start == 0) {
                res = sum;
                start++;
            } else {
                if (sum < res)
                    res = sum;
            }
        }

        return res;
    }
}