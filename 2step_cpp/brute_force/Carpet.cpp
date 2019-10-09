#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

vector<int> solution(int brown, int red) {
    vector<int> answer;
    int mul = brown + red;
    int start = sqrt(mul)+1;
    while(start>0){
        int div = mul / start;
        int mod = mul % start;
        if (mod == 0){
            int col = max(start, div);
            int row = min(start, div);
            int outline = 2 * (row+col) - 4;
            if (outline == brown){
                answer.push_back(col);
                answer.push_back(row);
                break;  
            }
            
        }
        start--;
        
    }
    return answer;
}
