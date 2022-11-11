import sys
from collections import defaultdict
input = sys.stdin.readline

answers = list()
dic = defaultdict(int)
for _ in range(int(input())):
	words = input().split()
	tmp = list()
	cnt = 0
	flag = False
	for word in words:
		if flag:
			tmp.append(word)
			continue
		if word[0].upper() in dic:
			cnt += 1
			tmp.append(word)
		elif word[0].upper() not in dic and not flag:
			tmp.append(word.replace(word[0], '['+word[0]+']', 1))
			dic[word[0].upper()] += 1
			flag = True
 
	if cnt == len(words):
		tmp = []
		for word in words:
			cnt = 0
			if flag:
				tmp.append(word)
				continue
			for j in word:
				if j.upper() in dic:
					cnt += 1
					if cnt == len(word):
						tmp.append(word)
				elif not flag and j.upper() not in dic:
					flag = True
					dic[j.upper()] += 1
					tmp.append(word.replace(j, '['+j+']', 1))
					continue
	answers.append(' '.join(tmp))
 
for word in answers:
	print(word)