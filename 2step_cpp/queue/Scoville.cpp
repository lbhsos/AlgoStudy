#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

priority_queue<int,vector<int>, greater<int>> pq;
void mix(void){
    int one = pq.top();
    pq.pop();
    int two = pq.top();
    pq.pop();
    pq.push((one+(two*2)));
    
}
int solution(vector<int> scoville, int K) {
    int answer = 0;
    
    for(int i=0; i<scoville.size(); i++){
        pq.push(scoville[i]);
    }
    
    while(1){
        int n = pq.size();
        if(pq.top()<K && n <= 1) return -1;
        if(pq.top()<K){
            mix();
            answer++;
        }else{
            break;
        }
    }
    return answer;
}

