# 기본 값 설정
loginCheck = False
loginCount = 0

idCheck = False
pwCheck = False

ID = "홍길동"
PW = "ABC"

dict = {}  # 가계부 딕셔너리


while(True):

    if loginCount == 3:
        # 로그인 횟수가 초과한 경우
        print("3회 오류로 프로그램을 종료합니다.")
        break

    if loginCheck == False:
        # 로그인이 안 된 경우

        if idCheck == False:
            # 아이디 인증이 안된 경우
            userInputID = input("아이디를 입력하세요 :")

            if userInputID == ID:
                # 아이디 입력 후 맞은 경우
                idCheck = True
                continue
            else:
                # 아이디가 틀린 경우
                print("아이디가 틀렸습니다. 다시 입력하세요:", userInputID)
                loginCount += 1
                continue

        elif idCheck == True:
            # 아이디 인증이 되고, 패스워드 인증이 남은 경우
            userInputPW = input("비밀번호를 입력하세요 :")

            if userInputPW == PW:
                # 패스워드가 맞은 경우
                loginCheck = True
                pwCheck = True  # 사실 없어도됨
            else:
                # 패스워드가 틀린 경우
                print("비밀번호가 틀렸습니다. 다시 입력하세요:", userInputPW)
                loginCount += 1
                continue

    elif loginCheck == True:
        # 로그인이 성공한 경우
        print("홍길동님 환영합니다.")

        while(True):
            ch = int(input("메뉴를 선택하세요 1=출력 2=입력 3=삭제 0=종료 :"))

            if ch == 1:
                # 출력
                if not dict:
                    print("출력할 내용이 없습니다.")
                else:
                    totalPrice = 0
                    for key in dict:
                        totalPrice += int(dict[key])
                    print(dict, ", 총액은", totalPrice, "원입니다.")

            elif ch == 2:
                # 입력
                menu, price = input("새로운 항목과 가격을 입력하세요:").split()
                dict[menu] = price

            elif ch == 3:
                # 삭제
                key = input("삭제할 항목을 입력하세요:")
                temp = dict[key]
                dict.pop(key)
                print(key, temp, "항목이 삭제 되었습니다.")

            elif ch == 0:
                break
            else:
                print("입력이 잘못 되었습니다. 다시 입력해주세요.")

        print("가계부 프로그램을 종료합니다.")
        break
