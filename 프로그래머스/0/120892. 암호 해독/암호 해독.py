def solution(cipher, code):
    answer = ''
    
    if code == 1:
        return cipher
    
    for i in range(0, len(cipher)):
        if (i+1) % code == 0 :
            answer += (cipher[i])
    return answer