import sys
n = int(sys.stdin.readline())
cranes = sorted(map(int, sys.stdin.readline().split()), reverse=True)
m = int(sys.stdin.readline())
boxes = sorted(map(int, sys.stdin.readline().split()), reverse=True)

if cranes[0] < boxes[0]:
    print(-1)
    exit()

def binary_search(l, r):
    def check(t):
        if n * t < m:
            return False
        for i in range(t, m, t):
            if boxes[i] > cranes[i // t]:
                return False
        return True
    while l <= r:
        mid = (l+r)//2
        if check(mid):
            ans = mid
            r = mid-1
        else:
            l = mid+1
    return ans

print(binary_search(1, m))