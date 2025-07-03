package leetcode.array;

//134. Gas Station
public class GasStation {
    public static void main(String[] args) {

    }

    int findStartingStation(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startingIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            totalTank += gain;
            currTank += gain;

            if (currTank < 0) {
                currTank = 0;
                startingIndex = i + 1;
            }
        }
        return totalTank >= 0 ? startingIndex : -1;
    }
}
