cnt = 1
result = []
stack = []
message = 1

n = int(input())
for _ in range(n):

    num = int(input())

    while cnt <= num:
        
        stack.append(cnt)
        result.append('+')
        cnt += 1
        
    if stack[-1] == num:
        stack.pop()
        result.append('-')
    
    else:
        message = False

if message == False:
    print("NO")

else:
    for _ in range(len(result)):
        print(result[_])