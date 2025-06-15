def plusOne(digits: list[int]) -> list[int]:
    # performed the sum here
    storeSum = ""
    for value in digits:
        storeSum += str(value)
    storeSum = int(storeSum) + 1
    
    # split the whole thing in a list and return
    finalList = []
    for eachEle in str(storeSum):
        finalList.append(int(eachEle))
    return finalList

plusOne([7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6])