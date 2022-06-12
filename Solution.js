
/**
 * @param {number[]} spells
 * @param {number[]} potions
 * @param {number} success
 * @return {number[]}
 */
var successfulPairs = function (spells, potions, success) {
    const sizeSpells = spells.length;
    const sizePotions = potions.length;

    const pairs = new Array(sizeSpells).fill(0);
    potions.sort((x, y) => x - y);

    for (let i = 0; i < sizeSpells; ++i) {
        pairs[i] = sizePotions - searchForIndexOfSmallestSuccessfulMatch(potions, spells[i], success);
    }
    return pairs;
};

/**
 * @param {number[]} potions
 * @param {number} current
 * @param {number} success
 * @return {number}
 */
function searchForIndexOfSmallestSuccessfulMatch(potions, current, success) {
    let left = 0;
    let right = potions.length - 1;
    
    while (left <= right) {
        let middle = left + Math.floor((right - left) / 2);
        if (current * potions[middle] >= success) {
            right = middle - 1;
        } else {
            left = middle + 1;
        }
    }
    return left; //if no match is found, left = potions.length
}
