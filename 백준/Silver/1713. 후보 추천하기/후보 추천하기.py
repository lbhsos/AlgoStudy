N = int(input()) # 사진틀 갯수 20 개 이하
cnt = int(input())
students = list(map(int, input().split(" ")))
frames = dict()

def delete_frames():
    global frames
    sorted_frames = sorted(frames.items(), key=lambda item: (item[1][0], item[1][1]))
    del frames[sorted_frames[0][0]]


for i, student in enumerate(students):
    if student not in frames:
        if len(frames) >= N:
            delete_frames()
        frames[student] = (1, i)
        continue
    all_cnt, idx = frames[student]
    frames[student] = (all_cnt + 1, idx)

sorted_frames = sorted(frames.keys())
print(' '.join(str(x) for x in sorted_frames))





