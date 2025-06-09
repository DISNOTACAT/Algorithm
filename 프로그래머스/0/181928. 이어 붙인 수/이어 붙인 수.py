def solution(num_list):
    answer1 = ''
    answer2 = ''
    for i in range(len(num_list)):
        if num_list[i] % 2 == 0:
            answer2 += str(num_list[i])
        else:
            answer1 += str(num_list[i])
    
    return int(answer1) + int(answer2)