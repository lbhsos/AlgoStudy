#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    vector<int> stack;
    int length = prices.size();
    int count = 0;
    
    for(int i=0; i<length; i++){
        int cur = prices[i];
        int start = 0;
        for(int j=i+1; j<length; j++){
            int next = prices[j];
            start++;
            if (cur > next){
                break;
            }
        }
        answer.push_back(start);
    }
    return answer;
}
