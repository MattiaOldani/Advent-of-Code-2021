public class Part02 {
    public static int Solve(String input) {
        String[] rangeX = input.split("x=")[1].split(",")[0].split("_");
        int minX = Integer.parseInt(rangeX[0]);
        int maxX = Integer.parseInt(rangeX[1].split(",")[0]);
        String[] rangeY = input.split("y=")[1].split("_");
        int minY = Integer.parseInt(rangeY[0]);
        int maxY = Integer.parseInt(rangeY[1]);
        
        int counter = 0;
        for (int i = - 1 + (int)Math.sqrt(1 + 8 *minX) / 2; i <= maxX; i++) {
            for (int j = minY; j <= maxX; j++) {
                int x = 0;
                int y = 0;
                int vx = i;
                int vy = j;
                while (true) {
                    x += vx;
                    y += vy--;
                    if (vx > 0)
                        vx--;
                    if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
                        counter++;
                        break;
                    }
                    if (x > maxX || y < minY)
                        break;
                }
            }
        }

        return counter;
    }
}