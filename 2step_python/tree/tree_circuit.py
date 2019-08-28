import pprint

n = int(input())
tree ={}
pre_arr = []
in_arr = []
post_arr = []
for _ in range(n):
    root, left, right = input().split(" ")
    tree[root] = {'left': left, 'right': right, 'data': root}
tree['.'] = None

def preorder(node):
    global tree
    if node == None: 
        return
    char = node['data']
    pre_arr.append(char)
    preorder(tree[node['left']])
    preorder(tree[node['right']])
 
    
def inorder(node):
    global tree
    if node == None: 
        return
    char = node['data']
    inorder(tree[node['left']])
    in_arr.append(char)
    inorder(tree[node['right']])

def postorder(node):
    global tree
    if node == None: 
        return
    char = node['data']
    postorder(tree[node['left']])
    postorder(tree[node['right']])
    post_arr.append(char)
    
preorder(tree['A'])
inorder(tree['A'])
postorder(tree['A'])

print(''.join(pre_arr))
print(''.join(in_arr))
print(''.join(post_arr))

#pprint.pprint(tree)
