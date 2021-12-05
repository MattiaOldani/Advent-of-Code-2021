import java.util.List;

public class Part02 {
    public static int Solve(List<String> input) {
        Integer[][] fields = new Integer[1000][1000];
        
        for (int i = 0; i < 1000; i++)
            for (int j = 0; j < 1000; j++)
                fields[i][j] = 0;

        int res = 0;
        for (int i = 0; i < input.size(); i++) {
            String[] line = input.get(i).split(" -> ");
            String[] first = line[0].split(",");
            String[] second = line[1].split(",");
            int x1 = Integer.parseInt(first[0], 10);
            int y1 = Integer.parseInt(first[1], 10);
            int x2 = Integer.parseInt(second[0], 10);
            int y2 = Integer.parseInt(second[1], 10);


            if (x1 == x2) {
                int start = (y1 < y2) ? y1 : y2;
                int end = (y1 == start) ? y2 : y1;
                for (int t = start; t <= end; t++) {
                    fields[t][x1]++;
                    if (fields[t][x1] == 2)
                        res++;
                }
            } else if (y1 == y2) {
                int start = (x1 < x2) ? x1 : x2;
                int end = (x1 == start) ? x2 : x1;
                for (int t = start; t <= end; t++) {
                    fields[y1][t]++;
                    if (fields[y1][t] == 2)
                        res++;
                }
            } else {
                int start_y = (y1 < y2) ? y1 : y2;
                int start_x = (y1 == start_y) ? x1 : x2;
                int end_x = (x1 == start_x) ? x2 : x1; 
                if (start_x < end_x) {
                    for (int x = start_x, y = start_y; x <= end_x; x++, y++) {
                        fields[y][x]++;
                        if (fields[y][x] == 2)
                            res++;
                    }
                } else {
                    for (int x = start_x, y = start_y; x >= end_x; x--, y++) {
                        fields[y][x]++;
                        if (fields[y][x] == 2)
                            res++;
                    }
                }
            }
        }
        
        return res;
    }
}