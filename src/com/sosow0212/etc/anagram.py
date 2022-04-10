str1, str2 = input().split()
str1Dict = {}
str2Dict = {}

for i in str1:
    str1Dict[i] = str1Dict.get(i, 0) + 1

for i in str2:
    str2Dict[i] = str2Dict.get(i, 0) + 1

if str1Dict == str2Dict:
    print("Yes")
else:
    print("no")
