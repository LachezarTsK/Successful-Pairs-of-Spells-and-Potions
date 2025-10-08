
function successfulPairs(spells: number[], potions: number[], success: number): number[] {
    potions.sort((x, y) => x - y);
    const successPairs: number[] = new Array(spells.length).fill(0);

    for (let i = 0; i < spells.length; ++i) {
        if (potions[potions.length - 1] * spells[i] < success) {
            continue;
        }
        const minSuccessIndex = binarySearchMinSuccessIndex(potions, spells[i], success);
        const numberOfSuccessPairs = potions.length - minSuccessIndex;
        successPairs[i] = numberOfSuccessPairs;
    }

    return successPairs;
};

function binarySearchMinSuccessIndex(potions: number[], spell: number, success: number): number {
    let left = 0;
    let right = potions.length - 1;

    while (left <= right) {
        const middle = left + Math.floor((right - left) / 2);

        if (potions[middle] * spell < success) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
    }
    return left;
}
