def solution(arr1, arr2):
    answer = []
    
    n, m, p = len(arr1), len(arr1[0]), len(arr2[0]);
    
    for i in range(0, n):
        arr = arr1[i]
        sumArr = []
        
        for j in range(0, p):
            total = 0
            
            for k in range(0, m):
                total += arr[k] * arr2[k][j]
            
            sumArr.append(total)
        
        answer.append(sumArr)
        
        
    return answer