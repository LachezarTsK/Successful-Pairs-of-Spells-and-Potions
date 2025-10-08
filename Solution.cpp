
#include <ranges>
#include <vector>
using namespace std;

class Solution {

public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) const {
        ranges::sort(potions);
        vector<int> successPairs(spells.size());

        for (int i = 0; i < spells.size(); ++i) {
            if (static_cast<long long>(potions[potions.size() - 1]) * spells[i] < success) {
                continue;
            }
            int minSuccessIndex = binarySearchMinSuccessIndex(potions, spells[i], success);
            int numberOfSuccessPairs = potions.size() - minSuccessIndex;
            successPairs[i] = numberOfSuccessPairs;
        }

        return successPairs;
    }

private:
    int binarySearchMinSuccessIndex(span<const int> potions, int spell, long long success) const {
        int left = 0;
        int right = potions.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (static_cast<long long>(potions[middle]) * spell < success) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }
        return left;
    }
};
