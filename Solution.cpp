
#include <vector>
using namespace std;

class Solution {
    
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        int sizeSpells = spells.size();
        int sizePotions = potions.size();

        vector<int> pairs(sizeSpells);
        sort(potions.begin(), potions.end());

        for (int i = 0; i < sizeSpells; ++i) {
            pairs[i] = sizePotions - searchForIndexOfSmallestSuccessfulMatch(potions, spells[i], success);
        }
        return pairs;
    }

private:
    int searchForIndexOfSmallestSuccessfulMatch(const vector<int>& potions, long long current, long long sucess) {
        int left = 0;
        int right = potions.size() - 1;

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
};
