class Solution {
public:
    string largestNumber(vector<int>& nums) {
        bool allZeros = true;
        for (int n : nums) {
            if (n != 0) {
                allZeros = false;
            }
        }
        if (allZeros) {
            return "0";
        }

        std::vector<std::vector<int>> numsAsArrays;
        for (int n : nums) {
            numsAsArrays.push_back(asIntArray(n));
        }

        // selecion sort
        for (int i = 0; i < nums.size(); i++) {
            std::vector<int> currMax = numsAsArrays[i];
            int currMaxIdx = i;
            for (int j = i+1; j < nums.size(); j++) {
                if (compare(numsAsArrays[j], currMax) > 0) {
                    currMax = numsAsArrays[j];
                    currMaxIdx = j;
                }
            }
            auto temp = numsAsArrays[i];
            numsAsArrays[i] = numsAsArrays[currMaxIdx];
            numsAsArrays[currMaxIdx] = temp;
        }
        std::stringstream out;
        for (auto num : numsAsArrays) {
          for (int digit : num) {
            out << digit;
          }
        }
        return out.str();
    }

    vector<int> asIntArray(int number) {
        vector<int> digitsArr;
        if (number == 0) {
            return {0};
        }
        while (number > 0) {
            digitsArr.insert(digitsArr.begin(), number % 10);
            number /= 10;
        }
        return digitsArr;
    }

    int compare(const vector<int> &num1, const vector<int> &num2) {
        int totalDigits = num1.size() + num2.size();
        std::vector<int> num1num2;
        std::vector<int> num2num1;
        num1num2.insert(num1num2.end(), num1.begin(), num1.end());
        num1num2.insert(num1num2.end(), num2.begin(), num2.end());
        num2num1.insert(num2num1.end(), num2.begin(), num2.end());
        num2num1.insert(num2num1.end(), num1.begin(), num1.end());
        for (int i = 0; i < totalDigits; i++) {
            if (num1num2[i] > num2num1[i]) {
                return 1;
            } else if (num1num2[i] < num2num1[i]) {
                return -1;
            }
        }
        return 0;
    }
};
