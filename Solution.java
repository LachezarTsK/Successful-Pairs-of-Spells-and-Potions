
import java.util.Arrays;

public class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] successPairs = new int[spells.length];

        for (int i = 0; i < spells.length; ++i) {
            if ((long) potions[potions.length - 1] * spells[i] < success) {
                continue;
            }
            int minSuccessIndex = binarySearchMinSuccessIndex(potions, spells[i], success);
            int numberOfSuccessPairs = potions.length - minSuccessIndex;
            successPairs[i] = numberOfSuccessPairs;
        }

        return successPairs;
    }

    private int binarySearchMinSuccessIndex(int[] potions, int spell, long success) {
        int left = 0;
        int right = potions.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if ((long) potions[middle] * spell < success) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
}
