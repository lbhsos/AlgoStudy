girl, boy, intern = map(int, input("").split(' '))
team_num = boy if girl >= 2 * boy else girl // 2
print(int(team_num - max(intern - (boy + girl - team_num * 3), 0) / 3))