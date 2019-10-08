#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

string solution(int n){
    string answer = "";
    
    int mod = 0;
    int div = 0;
    stack<int> st;
    
    while(n>0){
        div = n / 3;
        mod = n % 3;
        
        n = div;
        if (mod == 1){
            st.push(1);
        }else if(mod == 2){
            st.push(2);
        }else{
            st.push(4);
            n--;
        }

    }
    
    while(!st.empty()){
        int s = st.top();
        st.pop();
        answer += to_string(s);
    }

    

    return answer;
}

