
using System;

public class Solution
{
    public int[] SuccessfulPairs(int[] spells, int[] potions, long success)
    {
        Array.Sort(potions);
        int[] successPairs = new int[spells.Length];

        for (int i = 0; i < spells.Length; ++i)
        {
            if ((long)potions[potions.Length - 1] * spells[i] < success)
            {
                continue;
            }
            int minSuccessIndex = BinarySearchMinSuccessIndex(potions, spells[i], success);
            int numberOfSuccessPairs = potions.Length - minSuccessIndex;
            successPairs[i] = numberOfSuccessPairs;
        }

        return successPairs;
    }

    private int BinarySearchMinSuccessIndex(int[] potions, int spell, long success)
    {
        int left = 0;
        int right = potions.Length - 1;

        while (left <= right)
        {
            int middle = left + (right - left) / 2;

            if ((long)potions[middle] * spell < success)
            {
                left = middle + 1;
            }
            else
            {
                right = middle - 1;
            }
        }
        return left;
    }
}
