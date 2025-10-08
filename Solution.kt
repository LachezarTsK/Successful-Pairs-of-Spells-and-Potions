
class Solution {

    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        potions.sort()
        val successPairs = IntArray(spells.size)

        for (i in spells.indices) {
            if (potions[potions.size - 1].toLong() * spells[i] < success) {
                continue
            }
            val minSuccessIndex = binarySearchMinSuccessIndex(potions, spells[i], success)
            val numberOfSuccessPairs = potions.size - minSuccessIndex
            successPairs[i] = numberOfSuccessPairs
        }

        return successPairs
    }

    private fun binarySearchMinSuccessIndex(potions: IntArray, spell: Int, success: Long): Int {
        var left = 0
        var right = potions.size - 1

        while (left <= right) {
            val middle = left + (right - left) / 2

            if (potions[middle].toLong() * spell < success) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }
        return left
    }
}
