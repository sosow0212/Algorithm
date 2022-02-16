S, K, H = map(int, input().split())
d = {S: "Soongsil", K: "Korea", H: "Hanyang"}
if sum(d) >= 100:
    print("OK")
else:
    print(d[min(d)])
