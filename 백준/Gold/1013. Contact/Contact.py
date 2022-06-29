import re

T = int(input())
for _ in range(T):
    input_text = input().strip()
    results = re.fullmatch(r'(100+1+|01)+', input_text)

    if results == None:
        print("NO")
        continue

    if (results.end() - results.start()) != len(input_text):
        print("NO")
        continue
    print("YES")