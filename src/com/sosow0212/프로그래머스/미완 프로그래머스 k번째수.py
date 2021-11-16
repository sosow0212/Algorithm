i, j, k = list(map(int, input().split()))
sample = []
array = []
sample = list(map(int, input().split()))
for m in range(i-1, j) :
    val = sample[m]
    array.append(val)
array.sort()
print(array[k-1])