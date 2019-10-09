#include <string>
#include <vector>
#include <iostream>

using namespace std;

int dfs(int sum, int idx,vector<int> numbers, int target){
    if (sum == target && idx == numbers.size()) return 1;
    if (idx >= numbers.size()) return 0;

    int cur = numbers[idx]; 
    
    return dfs(sum+cur, idx+1,numbers, target) + dfs(sum-cur, idx+1, numbers, target);
}

int solution(vector<int> numbers, int target) {
    target = target;
    int answer = 0;
    int answer2= 0;
    answer = dfs(0+numbers[0], 1, numbers, target) + dfs(0-numbers[0], 1, numbers, target);
    
    return answer;
}




