n = int(input())
for x in range(n):
	a, b = input().split()
	a, b = int(f"0b{a}", 2), int(f"0b{b}", 2)
	result = bin(a + b)[2:]
	print(result)
