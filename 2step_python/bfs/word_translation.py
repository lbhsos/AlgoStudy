from queue import Queue
g_words = []
visit = []

def solution(begin, target, words):
    global g_words
    global visit
    g_words = words
    answer = 0
    visit = [False] * len(words)
    q = Queue()
    #q.put([-1, begin])
    compare_word(begin,q)
    
    while not q.empty():
        current = q.get()
        if current is None:  
            answer+=1
            #print(answer)
            q.put(None)
            if q.peek() is None:
                break
        else:
            current_index = current[0]
            current_word = current[1]

        if current_index != -1:
            visit[current_index] = True
                
        if current_word is target: 
            break
        if visit[current_index] != True:
            compare_word(current_word)
            
    

    return answer
        
    
def compare_word(origin,q):
    #print("g_words : ", len(g_words))
    for i in range(len(g_words)):
       # print("h")
        count = compare_char_diff(origin,g_words[i])
        if count is 1 and visit[i] is not True:
            q.put([i, g_words[i]])
          #  print(visit)
        q.put(None)
            
def compare_char_diff(origin, target):
    count=0
    for i in range(len(origin)):
        if origin[i] is not target[i]:
            count+=1
    return count
        
