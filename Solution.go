
package main
import "slices"

func successfulPairs(spells []int, potions []int, success int64) []int {
    slices.Sort(potions)
    successPairs := make([]int, len(spells))

    for i := range spells {
        if int64(potions[len(potions) - 1]) * int64(spells[i]) < success {
            continue
        }
        minSuccessIndex := binarySearchMinSuccessIndex(potions, spells[i], success)
        numberOfSuccessPairs := len(potions) - minSuccessIndex
        successPairs[i] = numberOfSuccessPairs
    }

    return successPairs
}

func binarySearchMinSuccessIndex(potions []int, spell int, success int64) int {
    left := 0
    right := len(potions)

    for left <= right {
        middle := left + (right - left) / 2

        if int64(potions[middle]) * int64(spell) < success {
            left = middle + 1
        } else {
            right = middle - 1
        }
    }
    return left
}
