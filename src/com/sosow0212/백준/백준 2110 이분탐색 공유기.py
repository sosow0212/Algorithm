# 답은 맞는데 오류

n, c = list(map(int,input().split()))
arr = []
for i in range(0,n) :
    val = int(input())
    arr.append(val)

start = 0
end = max(arr)

while start <= end :
    total = 0
    mid = (start + end) // 2
    for i in arr :
        if i > mid :
            total += i - mid
    
    if total < c :
        end = mid - 1
    else :
        ans = total
        start = mid + 1

print(ans)