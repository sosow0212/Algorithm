import sys
input = sys.stdin.readline

N = int(input())
stack = []
ans = 1

for i in range(N):
    val = int(input())
    stack.append(val)


num = stack.pop()  # N-1

for i in reversed(range(N-1)):
    if stack[i] > num:
        ans += 1
    stack.pop()
print(ans)
