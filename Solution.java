
import java.util.Arrays;

public class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int sizeSpells = spells.length;
        int sizePotions = potions.length;

        int[] pairs = new int[sizeSpells];
        Arrays.sort(potions);

        for (int i = 0; i < sizeSpells; ++i) {
            pairs[i] = sizePotions - searchForIndexOfSmallestSuccessfulMatch(potions, spells[i], success);
        }
        return pairs;
    }

    private int searchForIndexOfSmallestSuccessfulMatch(int[] potions, long current, long sucess) {
        int left = 0;
        int right = potions.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (current * potions[middle] >= sucess) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left; //if no match is found, left = potions.length
    }
}
