package final_prep.dsa.array.stack;

import java.util.Arrays;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] cars = new Integer[n];
        for (int i = 0; i < n; i++) {
            cars[i] = i;
        }
        Arrays.sort(cars, (a, b) -> position[b] - position[a]);
        int fleets = 0;
        double previousTime = 0;
        for (int i : cars) {
            double currentTime = (double) (target - position[i]) / speed[i];
            if (currentTime > previousTime) {
                fleets++;
                previousTime = currentTime;
            }
        }

        return fleets;
    }
}
