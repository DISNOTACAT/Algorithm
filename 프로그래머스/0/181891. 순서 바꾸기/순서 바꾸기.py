def solution(num_list, n):
    front = num_list[0:n]
    answer = num_list[n:len(num_list)]
    answer += front
    return answer